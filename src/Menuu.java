import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Menu {
    protected List<String> options;

    public Menu() {
        this.options = new ArrayList<>();
        initializeOptions();
    }

    protected abstract void initializeOptions();

    public void display() {
        System.out.println("\nMenu:");
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
        System.out.println((options.size() + 1) + ". Exit");
    }

    public int getChoice(Scanner scanner) {
        int choice = -1;
        while (choice < 1 || choice > options.size() + 1) {
            System.out.print("Kies een optie: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice < 1 || choice > options.size() + 1) {
                    System.out.println("Verkeerde keuze. Probeer het opnieuw");
                }
            } else {
                System.out.println("Verkeerde keuze. Probeer het opnieuw.");
                scanner.next();
            }
        }
        return choice;
    }

    public abstract void handleChoice(int choice, Scanner scanner, MenuController menuController);
}

class MainMenu extends Menu {
    @Override
    protected void initializeOptions() {
        options.add("Kleding Menu");
        options.add("Kleding Engels Menu");
        options.add("Mandje");
    }

    @Override
    public void handleChoice(int choice, Scanner scanner, MenuController menuController) {
        switch (choice) {
            case 1:
                menuController.navigateKledingMenu(scanner);
                break;
            case 2:
                menuController.navigateKledingEngelsMenu(scanner);
                break;
            case 3:
                menuController.viewMandje();
                break;
            case 4:
                System.out.println("Applicatie wordt gesloten...");
                System.exit(0);
                break;
            default:
                System.out.println("Verkeerde keuze. Probeer opnieuw.");
        }
    }
}

class MenuManager {
    private Menu menu;

    public MenuManager(Menu menu) {
        this.menu = menu;
    }

    public int displayAndGetChoice(Scanner scanner) {
        menu.display();
        return menu.getChoice(scanner);
    }

    public void handleChoice(int choice, Scanner scanner, MenuController menuController) {
        menu.handleChoice(choice, scanner, menuController);
    }
}


class KledingMenu {
    private List<Kleding> kledingItems;
    private Currency currency;

    public KledingMenu(List<Kleding> kledingItems, Currency currency) {
        this.kledingItems = kledingItems;
        this.currency = currency;
    }

    public void displayOptions() {
        for (int i = 0; i < kledingItems.size(); i++) {
            Kleding item = kledingItems.get(i);
            Prijs prijs = new Prijs(item.getPrijs(), currency);
            System.out.println((i + 1) + ". " + item.getNaam() + " - " + currency.getName() + " " + prijs.getWaarde());
        }
    }

    public int getChoice(Scanner scanner) {
        int choice = -1;
        while (choice < 1 || choice > kledingItems.size()) {
            System.out.print("Kies een item: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice < 1 || choice > kledingItems.size()) {
                    System.out.println("Verkeerde input. Probeer opnieuw");
                }
            } else {
                System.out.println("Verkeerde input. Voer een nummer in");
                scanner.next();
            }
        }
        return choice;
    }

    public Kleding getItem(int index) {
        return kledingItems.get(index - 1);
    }
}