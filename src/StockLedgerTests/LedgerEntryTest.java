import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LedgerEntryTest {
    private LedgerEntry ledgerEntry;

    @Test
    void enqueuePurchase() {
        ledgerEntry = new LedgerEntry("Apple");
        StockPurchase stockPurchase = new StockPurchase("Apple",10);

        assertTrue(ledgerEntry.isEmpty());
        ledgerEntry.enqueuePurchase(stockPurchase);
        assertFalse(ledgerEntry.isEmpty());
    }

    @Test
    void dequeuePurchase() {
        ledgerEntry = new LedgerEntry("Apple");
        StockPurchase stockPurchase = new StockPurchase("Apple",10);
        StockPurchase stockPurchase2 = new StockPurchase("Apple",1000);

        ledgerEntry.enqueuePurchase(stockPurchase);
        ledgerEntry.enqueuePurchase(stockPurchase2);

        assertEquals(10, ledgerEntry.dequeuePurchase().getPrice());
        assertEquals(1000, ledgerEntry.dequeuePurchase().getPrice());

        assertTrue(ledgerEntry.isEmpty());
    }

    @Test
    void getSymbol() {
        ledgerEntry = new LedgerEntry("Apple");
        assertEquals("Apple", ledgerEntry.getSymbol());
    }

    @Test
    void isEmpty() {
        ledgerEntry = new LedgerEntry("Apple");
        StockPurchase stockPurchase = new StockPurchase("Apple",10);

        assertTrue(ledgerEntry.isEmpty());
        ledgerEntry.enqueuePurchase(stockPurchase);
        assertFalse(ledgerEntry.isEmpty());
    }
}