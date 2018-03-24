package com.step.bank;

public class Account {

    private static final int minimumBalance = 1000;
    private final String accountNumber;
    private double balance;

    public Account(String accountNumber, int balance) throws MinimumBalanceException, InvalidAccountNumberException {
        if(!accountNumber.matches("^\\d{4}-\\d{4}$")){
            throw new InvalidAccountNumberException();
        }
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
        return accountNumber;
    }

    public void withdraw(double amount) throws MinimumBalanceException {
        if(balance-amount < 1000) {
            throw new MinimumBalanceException();
        }
        balance -= amount;
    }
}
