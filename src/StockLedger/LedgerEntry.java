import java.util.Iterator;

/**
 * Ledger Entry that uses a linked list of Stock Purchase objects as a queue
 */
public class LedgerEntry {
    private LinkedDeque<StockPurchase> purchases;
    private String symbol;

    public LedgerEntry(String symbol) {
        purchases = new LinkedDeque<>();
        this.symbol = symbol;
    }

    /**
     * Adds a stock purchase object to the back of queue
     * @param purchase a stock purchase object
     */
    public void enqueuePurchase(StockPurchase purchase) {
        purchases.addToBack(purchase);
    }

    /**
     * Removes and returns the item from the front of the queue
     * @return StockPurchace a stock purchase object
     */
    public StockPurchase dequeuePurchase() {
        return purchases.removeFront();
    }

    /**
     * Returns the ledger entries symbol
     * @return String a string of the ledger entries symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Checks if the queue is empty or not
     * @return boolean true if empty and false if not
     */
    public boolean isEmpty() {
        return purchases.isEmpty();
    }

    /**
     * Prints each unique price from the queue and how frequent the given price is
     */
    public void printData() {
        Iterator<StockPurchase> iterator = purchases.getIterator();
        if (!iterator.hasNext()) {
            return;
        }
        double currentPrice = iterator.next().getPrice();
        int currentQuantity = 1;

        while (iterator.hasNext()) {
            StockPurchase purchase = iterator.next();
            if (purchase.getPrice() == currentPrice) {
                currentQuantity++;
            } else {
                System.out.print(currentPrice + " (" + currentQuantity + " shares), ");
                currentPrice = purchase.getPrice();
                currentQuantity = 1;
            }
        }
        System.out.println(currentPrice + " (" + currentQuantity + " shares)");
    }
}
