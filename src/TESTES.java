import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

class KledingMenuTest {

    @Test
    public void testPriceCalculationInEuro() {
        List<Kleding> kledingItems = new ArrayList<>();
        kledingItems.add(new Shirt(81.00, "Penguine Shirt"));
        Currency currency = new Currency.EURO();
        KledingMenu kledingMenu = new KledingMenu(kledingItems, currency);

        // Simulate selection of the first item
        Kleding selectedItem = kledingMenu.getItem(1);
        Prijs prijs = new Prijs(selectedItem.getPrijs(), currency);

        assertEquals(81.00, prijs.getWaarde(), 0.01);
        assertEquals("Penguine Shirt - Prijs: EURO 81.0", selectedItem.getNaam() + " - Prijs: " + currency.getName() + " " + prijs.getWaarde());
    }

    @Test
    public void testPriceCalculationInDollar() {
        List<Kleding> kledingItems = new ArrayList<>();
        kledingItems.add(new Shirt(81.00, "Penguine Shirt"));
        Currency currency = new Currency.DOLLAR();
        KledingMenu kledingMenu = new KledingMenu(kledingItems, currency);

        // Simulate selection of the first item
        Kleding selectedItem = kledingMenu.getItem(1);
        Prijs prijs = new Prijs(selectedItem.getPrijs(), currency);

        // Assuming the conversion rate from Euro to Dollar is 1:1 for simplicity
        assertEquals(81.00, prijs.getWaarde(), 0.01);
        assertEquals("Penguine Shirt - Prijs: DOLLAR 81.0", selectedItem.getNaam() + " - Prijs: " + currency.getName() + " " + prijs.getWaarde());
    }
}
