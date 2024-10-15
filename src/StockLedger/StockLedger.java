public class StockLedger implements StockLedgerInterface {
    @Override
    public void buy(String stockSymbol, int sharesBought, double pricePerShare) {

    }

    @Override
    public double sell(String stockSymbol, int sharesSold, double pricePerShare) {
        return 0;
    }

    @Override
    public boolean contains(String stockSymbol) {
        return false;
    }

    @Override
    public LedgerEntry getEntry(String stockSymbol) {
        return null;
    }
}
