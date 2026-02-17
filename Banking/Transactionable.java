package Banking;

public interface Transactionable {
    public void deposit(double amount);
    public void withdraw(double amount);
    public double checkBalance();
}
