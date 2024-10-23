/**
 * Stock Purchase object
 */
public class StockPurchase {
    private String symbol;
    private double price;

    public StockPurchase(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }

    /**
     * Returns the Stock Purchase symbol
     * @return String a string of the Stock Purchase symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Returns the price of the Stock Purchase
     * @return double a double of the Stock Purchase price
     */
    public double getPrice() {
        return price;
    }
}
