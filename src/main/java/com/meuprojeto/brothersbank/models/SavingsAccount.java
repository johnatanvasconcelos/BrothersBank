package com.meuprojeto.brothersbank.models;

import java.math.BigDecimal;

public class SavingsAccount extends BankAccount{
    public static final BigDecimal YIELD = new BigDecimal("0.005");

    public SavingsAccount(String accountNumber, BigDecimal balance) {
        super(accountNumber, balance);
    }

    public void implementYield(){
        BigDecimal yield = getBalance().multiply(YIELD);
        setBalance(getBalance().add(yield));
    }

}
