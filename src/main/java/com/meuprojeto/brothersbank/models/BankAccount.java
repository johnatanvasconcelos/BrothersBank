package com.meuprojeto.brothersbank.models;

public class BankAccount {
    private String accountNumber;
    private Double balance;

    public BankAccount(String accountNumber, Double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void withdraw(double value){
        setBalance(getBalance() - value);
    }

    public void deposit(double value){
        setBalance(getBalance() + value);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

}
