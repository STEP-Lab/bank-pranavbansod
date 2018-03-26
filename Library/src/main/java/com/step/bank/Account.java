package com.step.bank;

public class Account {

    private static final int minimumBalance = 1000;
    private final AccountNumber accountNumber;
    private double balance;

    public Account(AccountNumber accountNumber, int balance) throws MinimumBalanceException {
        this.accountNumber = accountNumber;
        validateMinimumBalance(balance);
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    private void validateMinimumBalance(double balance) throws MinimumBalanceException {
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
}
