import java.util.ArrayList;
import java.util.List;

abstract class Kleding {
    protected List<Observer> observers;
    protected Maat maat;

    protected Prijs prijs;

    public Kleding() {
        this.observers = new ArrayList<>();
        this.maat = new Maat();
    }
    public void setPrijs(Prijs prijs){
        this.prijs =prijs;
    };
    public void voegToe(Observer observer) {
        observers.add(observer);
    }

    public void verwijder(Observer observer) {
        observers.remove(observer);
    }

    public String[] getStandaardMaat() {
        return maat.getStandaardMaten();
    }

    public String[] getMaatEngels() {
        return maat.getEngelsMaten();
    }

    public String[] getMaatAccessoires() {
        return maat.getAccessoiresMaten();
    }

    public void meld() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public abstract double getPrijs();

    public abstract String getType();

    public abstract String getNaam();
}

class Shirt extends Kleding {
    private double prijs;
    private String type;
    private String naam;

    public Shirt(double prijs, String naam) {
        super();
        this.type = "Shirt";
        this.prijs = prijs;
        this.naam = naam;
    }

    @Override
    public double getPrijs() {
        return prijs;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getNaam() {
        return naam;
    }
}

class Hoodie extends Kleding {
    private Double prijs;
    private String type;
    private String naam;

    public Hoodie(double prijsWaarde, String naam) {
        super();
        this.type = "Hoodie";
        this.prijs = prijsWaarde;
        this.naam = naam;
    }

    @Override
    public double getPrijs() {
        return prijs;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getNaam() {
        return naam;
    }
}

class Broek extends Kleding {
    private Double prijs;
    private String type;
    private String naam;

    public Broek(double prijsWaarde, String naam) {
        super();
        this.type = "Broek";
        this.prijs = prijsWaarde;
        this.naam = naam;
    }

    @Override
    public double getPrijs() {
        return prijs;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getNaam() {
        return naam;
    }
}


