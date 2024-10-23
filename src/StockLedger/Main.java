public class Main {
    public static void main(String[] args) {
        StockLedger stockLedger = new StockLedger();

        stockLedger.buy("AAPL",20,45);
        stockLedger.buy("AAPL",20,75);
        stockLedger.buy("MSFT",20,95);
        stockLedger.displayLedger();

        stockLedger.sell("AAPL",30,65);
        stockLedger.displayLedger();

        stockLedger.sell("AAPL",10,65);
        stockLedger.displayLedger();

        stockLedger.buy("AAPL",100,20);
        stockLedger.buy("AAPL",20,24);
        stockLedger.buy("TSLA",200,36);
        stockLedger.displayLedger();

        stockLedger.sell("AAPL",10,65);
        stockLedger.displayLedger();

        stockLedger.sell("TSLA",150,30);
        stockLedger.displayLedger();

        stockLedger.buy("MSFT",5,60);
        stockLedger.buy("MSFT",5,70);
        stockLedger.displayLedger();

        stockLedger.sell("MSFT",4,30);
        stockLedger.displayLedger();

        stockLedger.sell("MSFT",2,30);
        stockLedger.displayLedger();






    }
}
