package com.step.bank;

import java.util.Date;

public class DebitTransaction extends Transaction {
    public DebitTransaction(double amount, String anotherAccount, Date date) {
        super(amount, anotherAccount, date);

    }

    public DebitTransaction(double amount, String anotherAccount) {
        super(amount, anotherAccount, new Date());
    }

}
