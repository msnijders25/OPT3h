import java.util.ArrayList;

public class Favorieten implements OpgeslagenItems {
    ArrayList<Kleding> kleding;

    @Override
    public ArrayList<Kleding> getKleding() {
        return kleding;
    }

    @Override
    public void setKleding(Kleding kleding, Prijs prijs) {

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
