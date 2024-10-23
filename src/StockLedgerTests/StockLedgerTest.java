import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StockLedgerTest {

    @Test
    void buy() {
        StockLedger stockLedger = new StockLedger();

        stockLedger.buy("Apple",5,10);
        assertTrue(stockLedger.contains("Apple"));
        stockLedger.buy("Microsoft",5,10);
        assertTrue(stockLedger.contains("Microsoft"));
    }

    @Test
    void sell() {
        StockLedger stockLedger = new StockLedger();

        stockLedger.buy("Apple",4,10);
        stockLedger.buy("Microsoft",4,10);

        assertEquals(20, stockLedger.sell("Apple",2,20));
        assertEquals(-10, stockLedger.sell("Microsoft",2,5));

        stockLedger.sell("Apple",2,10);
        assertFalse(stockLedger.contains("Apple"));
    }

    @Test
    void contains() {
        StockLedger stockLedger = new StockLedger();

        stockLedger.buy("Apple",5,10);
        assertTrue(stockLedger.contains("Apple"));

        stockLedger.buy("Microsoft",5,10);
        assertTrue(stockLedger.contains("Microsoft"));

        assertFalse(stockLedger.contains("Skyecompany"));
    }

    @Test
    void getEntry() {
        StockLedger stockLedger = new StockLedger();

        stockLedger.buy("Apple",4,10);
        stockLedger.buy("Microsoft",4,10);
        stockLedger.buy("Skyecompany",4,10);

        assertEquals("Apple",stockLedger.getEntry("Apple").getSymbol());
        assertEquals("Microsoft",stockLedger.getEntry("Microsoft").getSymbol());
        assertEquals("Skyecompany",stockLedger.getEntry("Skyecompany").getSymbol());
    }
}