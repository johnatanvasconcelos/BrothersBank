package com.meuprojeto.brothersbank.models;

import com.meuprojeto.brothersbank.exception.InsufficientFundsException;

public class BankAccount {
    private String accountNumber;
    private Double balance;

    public BankAccount(String accountNumber, Double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void withdraw(double value){
        if (getBalance() >= value){
            setBalance(getBalance() - value);
        } else{
            throw new InsufficientFundsException("Saldo insuficiente");
        }
    }

    public void deposit(double value){
        if (value <= 0 ){
            throw new IllegalArgumentException("Valor de depósito inválido");
        }
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
