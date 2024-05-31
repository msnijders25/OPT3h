abstract class Observer {
    protected Kleding kleding;

    public Observer(Kleding kleding) {
        this.kleding = kleding;
    }

    public abstract void update();
}

class ValutaConverter extends Observer {
    private double valutaKoers;

    public ValutaConverter(Kleding kleding, double valutaKoers) {
        super(kleding);
        this.valutaKoers = valutaKoers;
    }

    @Override
    public void update() {
        System.out.println("Bijgewerkte prijs voor " + kleding.getType() + ": " + (kleding.getPrijs() * valutaKoers));
    }
}