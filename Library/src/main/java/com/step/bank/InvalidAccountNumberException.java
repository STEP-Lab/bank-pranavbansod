package com.step.bank;

public class InvalidAccountNumberException extends Throwable {
    public InvalidAccountNumberException(){
        super("Invalid account number");
    }
}
