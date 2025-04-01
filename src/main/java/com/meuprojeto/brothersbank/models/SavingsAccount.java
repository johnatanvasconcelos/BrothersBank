package com.meuprojeto.brothersbank.models;

public class SavingsAccount extends BankAccount{
    public static final double YIELD = 0.005;

    public SavingsAccount(String accountNumber, Double balance) {
        super(accountNumber, balance);
    }

    public void implementYield(){
        setBalance(getBalance() + getBalance() * YIELD);
    }

}
