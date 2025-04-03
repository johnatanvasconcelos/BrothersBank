package com.meuprojeto.brothersbank.models;

import com.meuprojeto.brothersbank.exception.InsufficientFundsException;

import java.math.BigDecimal;

public class BankAccount {
    private Long id;
    private Long accountNumber;
    private final String ownerName;
    private BigDecimal balance;

    public BankAccount(String ownerName, BigDecimal balance) {
        this.ownerName = ownerName;
        this.balance = balance;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getOwnerName() {
        return ownerName;
    }

    @Override
    public String toString() {
        return "ID: " +
                getId() +
                " | " +
                "Proprietário: "
                + getOwnerName() +
                " | " +
                "Saldo na conta: R$ " +
                getBalance();
    }
}
