import java.util.ArrayList;

/**
 * Stock Ledger class creates an array list of ledger entries each with a unique symbol
 * each leger entry is a queue of stocks
 * you can buy and sell stocks which will add or remove them from their respective ledger entries
 */
public class StockLedger implements StockLedgerInterface {
    ArrayList<LedgerEntry> stocks;

    public StockLedger() {
        stocks = new ArrayList<LedgerEntry>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void buy(String stockSymbol, int sharesBought, double pricePerShare) {
        StockPurchase stockPurchase = new StockPurchase(stockSymbol, pricePerShare);
        LedgerEntry existingEntry = null;

        for (LedgerEntry entry : stocks) {
            if (entry.getSymbol().equals(stockSymbol)) {
                existingEntry = entry;
                break;
            }
        }

        if (existingEntry == null) {
            LedgerEntry newEntry = new LedgerEntry(stockSymbol);
            for (int i = 0; i < sharesBought; i++) {
                newEntry.enqueuePurchase(stockPurchase);
            }
            stocks.add(newEntry);
        }

        if (existingEntry != null) {
            for (int i = 0; i < sharesBought; i++) {
                existingEntry.enqueuePurchase(stockPurchase);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double sell(String stockSymbol, int sharesSold, double pricePerShare) {
        double capitalGain = 0;

        for (LedgerEntry entry : stocks) {
            if (entry.getSymbol().equals(stockSymbol)) {

                for (int i = 0; i < sharesSold; i++) {
                    StockPurchase removedPurchase = entry.dequeuePurchase();
                    capitalGain -= removedPurchase.getPrice();
                    capitalGain += pricePerShare;
                }

                if (entry.isEmpty()) {
                    stocks.remove(entry);
                }
            }
        }

        return capitalGain;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean contains(String stockSymbol) {
        for (LedgerEntry entry : stocks) {
            if(entry.getSymbol().equals(stockSymbol)) {
                return true;
            }
        }

        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LedgerEntry getEntry(String stockSymbol) {
        for (LedgerEntry entry : stocks) {
            if(entry.getSymbol().equals(stockSymbol)) {
                return entry;
            }
        }

        return null;
    }

    /**
     * Prints the name of each Ledger Entry then prints that data in each of the given entries
     */
    public void displayLedger() {
        System.out.println("---- Stock Ledger ---- ");
        for (LedgerEntry entry : stocks) {
            System.out.print(entry.getSymbol() + " ");
            entry.printData();
        }
    }
}
