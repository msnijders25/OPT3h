
public class Language implements ILanguage {
    String name;

    Language(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public class French extends Language implements ILanguage{
        French() {
            super("French");
        }
    }

    public static class English extends Language implements ILanguage {
        English() {
            super("English");
        }
    }

    public static class Dutch extends Language implements ILanguage {
        Dutch() {
            super("Dutch");
        }
    }
}
