import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class MenuInitializer {
    public Currency initCurrency(Language language) {
        if (language instanceof Language.English) {
            return new Currency.DOLLAR();
        } else if (language instanceof Language.Dutch) {
            return new Currency.EURO();
        } else {
            return new Currency.EURO();
        }
    }

    public List<String> initKledingMenuOptions() {
        List<String> options = new ArrayList<>();
        options.add("Shirts");
        options.add("Broeken");
        options.add("Hoodies");
        return options;
    }

    public List<Kleding> initKledingShirts() {
        List<Kleding> options = new ArrayList<>();
        options.add(new Shirt(81.00, "Penguine Shirt"));
        options.add(new Shirt(81.00, "Blanco Shirt2"));
        options.add(new Shirt(81.00, "Aarde Shirt3"));
        return options;
    }

    public List<Kleding> initKledingBroeken() {
        List<Kleding> options = new ArrayList<>();
        options.add(new Broek(81.00, "Pikachu Broek"));
        options.add(new Broek(81.00, "Oversized Broek"));
        options.add(new Broek(81.00, "Lange Broek"));
        return options;
    }

    public List<Kleding> initKledingHoodies() {
        List<Kleding> options = new ArrayList<>();
        options.add(new Hoodie(81.00, "Adidas Hoodie"));
        options.add(new Hoodie(81.00, "Oversized Hoodie"));
        options.add(new Hoodie(81.00, "Lange Hoodie"));
        return options;
    }

    public List<String> initKledingEngelsMenuOptions() {
        List<String> options = new ArrayList<>();
        options.add("Shirts");
        options.add("Pants");
        options.add("Hoodies");
        return options;
    }
}
