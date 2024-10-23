import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StockPurchaseTest {

    @Test
    void getSymbol() {
        StockPurchase stockPurchase = new StockPurchase("Apple",10);
        assertEquals("Apple", stockPurchase.getSymbol());

    }

    @Test
    void getPrice() {
        StockPurchase stockPurchase = new StockPurchase("Apple",10);
        assertEquals(10, stockPurchase.getPrice());
    }
}