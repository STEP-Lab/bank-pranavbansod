package com.step.bank;

import java.util.Date;

public class CreditTransaction extends Transaction {
    public CreditTransaction(double amount, String anotherAccount, Date date) {
        super(amount, anotherAccount, date);

    }

    public CreditTransaction(double amount, String anotherAccount) {
        super(amount, anotherAccount, new Date());
    }
}
