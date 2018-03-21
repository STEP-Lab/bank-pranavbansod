public class Account {

    private final String accountNumber;
    private double balance;

    public Account(String accountNumber, int balance) throws MinimumBalanceException, InvalidAccountNumberException {
        if(!accountNumber.matches("^\\d{4}-\\d{4}$")){
            throw new InvalidAccountNumberException();
        }
        this.accountNumber = accountNumber;
        if(balance<1000){
            throw new MinimumBalanceException();
        }
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void withdraw(double amount) throws MinimumBalanceException {
        if(balance-amount < 1000) {
            throw new MinimumBalanceException();
        }
        balance -= amount;
    }
}
