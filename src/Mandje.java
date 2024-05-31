import java.util.ArrayList;

public class Mandje implements OpgeslagenItems{
    ArrayList<Kleding> kleding;

    Mandje(ArrayList<Kleding> kleding){
        this.kleding = kleding;
    }

    public Mandje() {

    }

    @Override
    public ArrayList<Kleding> getKleding() {
        return kleding;
    }

    @Override
    public void setKleding(Kleding kleding, Prijs prijs) {
        kleding.setPrijs(prijs);
    this.kleding.add(kleding);
    }

    @Override
    public void setKleding(Kleding kleding) {
        this.kleding.add(kleding);
    }

    @Override
    public void verwijderKleding(Kleding kleding) {
        this.kleding.remove(kleding);
    }
}
