abstract class Country {

    String name;
    Language language;
    Currency currency;



    Country(String name, Language language, Currency currency) {
        this.name = name;
        this.language = language;
        this.currency = currency;
    }

    public Language getLanguage() {
        return language;
    }

    public Currency getCurrency() {
        return currency;
    }

    public static class UK extends Country {
        UK(Language.English english, Currency.POUND currency) {
            super("United Kingdom", english, currency);
        }
    }

    public static class NL extends Country {
        NL(Language.Dutch dutch, Currency.EURO currency) {
            super("Netherlands", dutch, currency);
        }
    }

    public static class US extends Country {
        US(Language.English english, Currency.DOLLAR currency) {
            super("United States", english, currency);
        }
    }
}