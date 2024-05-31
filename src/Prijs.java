public class Prijs {
    private double waarde;
    private ICurrency currency;

    public Prijs(double waarde, Currency currency) {
        this.waarde = waarde;
        this.currency = currency;
    }

    public double getWaarde() {
        return waarde * currency.getKoers();
    }

    public void setWaarde(double waarde) {
        this.waarde = waarde;
    }
}
