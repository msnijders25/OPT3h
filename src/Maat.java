class Maat {
    private String[] standaardMaten;
    private String[] engelsMaten;
    private String[] accessoiresMaten;

    public Maat() {
        initializeMaten();
    }

    private void initializeMaten() {
        standaardMaten = new String[]{"XS", "S", "M", "L", "XL"};
        engelsMaten = new String[]{"6", "8", "10", "12", "14", "16"};
        accessoiresMaten = new String[]{"S", "M", "L"};
    }

    public String[] getStandaardMaten() {
        return standaardMaten;
    }

    public String[] getEngelsMaten() {
        return engelsMaten;
    }

    public String[] getAccessoiresMaten() {
        return accessoiresMaten;
    }
}
