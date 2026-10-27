public class BankAccount {
    private String accountholder;
    private double balance;
    private static double interestRate;

    BankAccount(String accountHolder, double balance) {
        this.accountholder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double... amounts) {
        for (int i = 0; i < amounts.length; i++) {
            if (amounts[i] > 0) {
                balance += amounts[i];
            }
        }
    }

    double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        BankAccount b = new BankAccount(args[0], Double.parseDouble(args[1]));

        for (int i = 2; i < args.length; i++) {
            b.deposit(Double.parseDouble(args[i]));
        }

        b.deposit(500, 1000.5, -200, 300);

        System.out.println("Final Balance: " + b.getBalance());
    }
}
