import java.util.ArrayList;

public interface OpgeslagenItems {

    ArrayList<Kleding> getKleding();


    void setKleding(Kleding kleding, Prijs prijs);

    void setKleding(Kleding kleding);

    void verwijderKleding(Kleding kleding);
}
