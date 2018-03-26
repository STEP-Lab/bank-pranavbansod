package com.step.bank;

public class Account {

    private static final int minimumBalance = 1000;
    private final AccountNumber accountNumber;
    private double balance;

    public Account(AccountNumber accountNumber, double balance)  {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    private static void validateMinimumBalance(double balance) throws MinimumBalanceException {
        if(balance< minimumBalance){
            throw new MinimumBalanceException();
        }
    }

    public String getAccountNumber() {
        return accountNumber.getAccountNumber();
    }

    public void withdraw(double amount) throws MinimumBalanceException {
        if(balance-amount < 1000) {
            throw new MinimumBalanceException();
        }
        balance -= amount;
    }

    public static Account createAccount(AccountNumber number, int balance) throws MinimumBalanceException {
        validateMinimumBalance(balance);
        return new Account(number,balance);
    }
}
