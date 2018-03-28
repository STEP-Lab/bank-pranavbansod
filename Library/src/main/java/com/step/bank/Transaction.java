package com.step.bank;

import java.util.Date;
import java.util.Objects;


public abstract class Transaction {
    protected final double amount;
    protected final Date date;
    private final String anotherAccount;

    public Transaction(double amount, String anotherAccount, Date date) {
        this.anotherAccount = anotherAccount;
        this.amount = amount;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Double.compare(that.amount, amount) == 0 &&
                Objects.equals(anotherAccount, that.anotherAccount);
    }

    @Override
    public int hashCode() {

        return Objects.hash(amount, anotherAccount);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "amount=" + amount +
                ", date=" + date +
                ", anotherAccount='" + anotherAccount + '\'' +
                '}';
    }
}