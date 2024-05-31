import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class MenuController {
    private Account account;
    private MenuManager kledingMenuManager;
    private MenuManager kledingEngelsMenuManager;
    private MenuInitializer initializer;
    private Language currentLanguage;
    private Currency currentCurrency;

    public MenuController() {
        initializer = new MenuInitializer();
        List<String> kledingOptions = initializer.initKledingMenuOptions();
        List<String> kledingEngelsOptions = initializer.initKledingEngelsMenuOptions();

        kledingMenuManager = new MenuManager(new MenuConversieKleding(kledingOptions));
        kledingEngelsMenuManager = new MenuManager(new MenuConversieKledingEngels(kledingEngelsOptions));
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        selectAccount(scanner);
        MainMenu mainMenu = new MainMenu();

        while (true) {
            mainMenu.display();
            int choice = mainMenu.getChoice(scanner);
            mainMenu.handleChoice(choice, scanner, this);
        }
    }

    public void selectAccount(Scanner scanner) {
        System.out.println("Select Account:");
        System.out.println("1. Dutch Account");
        System.out.println("2. English Account (UK)");
        System.out.println("3. American Account (US)");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                account = new Account(new Login("dutch_user", "password"), new Country.NL(new Language.Dutch(), new Currency.EURO()));
                break;
            case 2:
                account = new Account(new Login("english_user", "password"), new Country.UK(new Language.English(), new Currency.POUND()));
                break;
            case 3:
                account = new Account(new Login("american_user", "password"), new Country.US(new Language.English(), new Currency.DOLLAR()));
                break;
            default:
                System.out.println("Verkeerde Keuze. Probeer opnieuw.");
                selectAccount(scanner);
                return;
        }
        currentLanguage = account.getCountry().getLanguage();
        currentCurrency = account.getCountry().getCurrency();
        System.out.println("Account selected: " + account.getCountry().name);
    }

    public void navigateKledingMenu(Scanner scanner) {
        int choice = kledingMenuManager.displayAndGetChoice(scanner);
        handleKledingMenuChoice(choice, scanner);
    }

    public void navigateKledingEngelsMenu(Scanner scanner) {
        int choice = kledingEngelsMenuManager.displayAndGetChoice(scanner);
        handleKledingMenuChoice(choice, scanner);
    }

    public void handleKledingMenuChoice(int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                showKledingSubMenu(initializer.initKledingShirts(), scanner);
                break;
            case 2:
                showKledingSubMenu(initializer.initKledingBroeken(), scanner);
                break;
            case 3:
                showKledingSubMenu(initializer.initKledingHoodies(), scanner);
                break;
            default:
                System.out.println("Invalid choice. Returning to main menu.");
        }
    }

    private void showKledingSubMenu(List<Kleding> opties, Scanner scanner) {
        KledingMenu subMenu = new KledingMenu(opties, currentCurrency);
        subMenu.displayOptions();
        int choice = subMenu.getChoice(scanner);
        Kleding selectedItem = subMenu.getItem(choice);

        Prijs prijs = new Prijs(selectedItem.getPrijs(), currentCurrency);
        selectedItem.setPrijs(prijs);
        Mandje mandje = account.getMandje();
        if (mandje == null) {
            mandje = new Mandje(new ArrayList<Kleding>());
            account.setMandje(mandje);
        }
        mandje.setKleding(selectedItem);

        System.out.println("Geselecteerde item: " + selectedItem.getNaam() + " - Prijs: " + currentCurrency.getName() + " " + prijs.getWaarde());
    }

    public void viewMandje() {
        Mandje mandje = account.getMandje();
        if (mandje == null || mandje.getKleding().isEmpty()) {
            System.out.println("Mandje is leeg.");
        } else {
            System.out.println("Content van mandje:");
            for (Kleding kleding : mandje.getKleding()) {
                System.out.println(kleding.getNaam() + " - Prijs: " + currentCurrency.getName() + " " + kleding.getPrijs());
            }
        }
    }
}
