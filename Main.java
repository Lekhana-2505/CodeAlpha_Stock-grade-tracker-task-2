import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Market stocks
        ArrayList<Stock> market = new ArrayList<>();
        market.add(new Stock("Apple", 150));
        market.add(new Stock("Tesla", 200));
        market.add(new Stock("Google", 180));

        User user = new User("Priya", 10000);
        Portfolio portfolio = new Portfolio();

        int choice;

        do {
            System.out.println("\n===== STOCK MARKET =====");
            System.out.println("1. View Market");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. View Balance");
            System.out.println("0. Exit");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\n--- Market Data ---");
                    for (Stock s : market) {
                        s.display();
                    }
                    break;

                case 2:
                    System.out.println("Enter stock name:");
                    String buyName = sc.next();

                    System.out.println("Enter quantity:");
                    int buyQty = sc.nextInt();

                    for (Stock s : market) {
                        if (s.name.equalsIgnoreCase(buyName)) {
                            double cost = buyQty * s.price;

                            if (cost <= user.balance) {
                                user.balance -= cost;
                                portfolio.buyStock(s.name, buyQty);
                                System.out.println("Stock Bought!");
                            } else {
                                System.out.println("Not enough balance!");
                            }
                        }
                    }
                    break;

                case 3:
                    System.out.println("Enter stock name:");
                    String sellName = sc.next();

                    System.out.println("Enter quantity:");
                    int sellQty = sc.nextInt();

                    for (Stock s : market) {
                        if (s.name.equalsIgnoreCase(sellName)) {
                            portfolio.sellStock(s.name, sellQty);
                            user.balance += sellQty * s.price;
                            System.out.println("Stock Sold!");
                        }
                    }
                    break;

                case 4:
                    portfolio.showPortfolio();
                    break;

                case 5:
                    user.showBalance();
                    break;
            }

        } while (choice != 0);

        System.out.println("Thank you!");
    }
}