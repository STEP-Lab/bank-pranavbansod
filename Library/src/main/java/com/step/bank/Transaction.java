package com.step.bank;

import java.util.Date;


public abstract class Transaction {
    protected final double amount;
    protected final String source;
    protected final Date date;

    public Transaction(String anotherAccount, double amount, Date date) {
        this.source = anotherAccount;
        this.amount = amount;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }
}