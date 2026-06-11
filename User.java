public class User {
    String name;
    double balance;

    public User(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public void showBalance() {
        System.out.println("Balance: ₹" + balance);
    }
}