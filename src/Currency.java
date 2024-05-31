// Modify the Currency class to implement ICurrency
public class Currency implements ICurrency {
    Double koers;
    String name;

    Currency(Double koers, String name) {
        this.koers = koers;
        this.name = name;
    }

    @Override
    public Double getKoers() {
        return koers;
    }

    @Override
    public String getName() {
        return name;
    }

    public static class EURO extends Currency implements ICurrency {
        public EURO() {
            super(0.83, "EURO");
        }
    }

    public static class DOLLAR extends Currency implements ICurrency {
        public DOLLAR() {
            super(1.0, "DOLLAR"); }
    }

    public static class POUND extends Currency implements ICurrency {
        public POUND() {
            super(0.72, "POUND");
        }
    }
}
