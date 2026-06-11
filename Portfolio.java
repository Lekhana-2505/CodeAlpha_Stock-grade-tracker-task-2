import java.util.HashMap;

public class Portfolio {
    HashMap<String, Integer> stocks = new HashMap<>();

    public void buyStock(String stock, int qty) {
        stocks.put(stock, stocks.getOrDefault(stock, 0) + qty);
    }

    public void sellStock(String stock, int qty) {
        if (stocks.containsKey(stock)) {
            int current = stocks.get(stock);
            if (current >= qty) {
                stocks.put(stock, current - qty);
            } else {
                System.out.println("Not enough stocks to sell!");
            }
        } else {
            System.out.println("Stock not found!");
        }
    }

    public void showPortfolio() {
        System.out.println("\n--- Portfolio ---");
        for (String s : stocks.keySet()) {
            System.out.println(s + " : " + stocks.get(s));
        }
    }
}