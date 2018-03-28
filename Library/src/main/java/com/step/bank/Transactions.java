package com.step.bank;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

public class Transactions {
    private ArrayList<Transaction> list;

    public Transactions() {
        this.list = new ArrayList<>();
    }

    public ArrayList<Transaction> getList() {
        return list;
    }

    public void debit(double amount, String to) {
        this.list.add(new DebitTransaction(amount,to));
    }

    public void debit(double amount, String to,Date date) {
        this.list.add(new DebitTransaction(amount,to,date));
    }

    public void credit(double amount, String from) {
        this.list.add(new CreditTransaction(amount,from));
    }

    public void credit(double amount, String from,Date date) {
        this.list.add(new CreditTransaction(amount,from,date));
    }

    public Transactions filterByAmountGreaterThan(int amount) {
        Transactions transactions = new Transactions();
        for(Transaction transaction : list) {
            if (transaction.getAmount() >= amount){
                transactions.getList().add(transaction);
            }
        }
        return transactions;
    }


    public Transactions getAllCredit() {
        Transactions transactions = new Transactions();
        for(Transaction transaction : list) {
            if (transaction instanceof CreditTransaction){
                transactions.getList().add(transaction);
            }
        }
        return transactions;
    }

    public Transactions getAllDebit() {
        Transactions transactions = new Transactions();
        for(Transaction transaction : list) {
            if (transaction instanceof DebitTransaction){
                transactions.getList().add(transaction);
            }
        }
        return transactions;
    }

    public Transactions filterByDateAfter(Date date) {
        Transactions transactions = new Transactions();
        for(Transaction transaction : list) {
            if(transaction.getDate().after(date))
            transactions.getList().add(transaction);
        }
        return transactions;
    }

//    public void print(PrintWriter printWriter) {
//
//    }
}