package br.com.john.brothersbank.models;

import java.math.BigDecimal;

public class SavingsAccount extends BankAccount{
    public static final BigDecimal YIELD = new BigDecimal("0.005");
    private static final String typeAccount = "Conta Poupança";


    public SavingsAccount(String ownerName) {
        super(ownerName);
    }

    public void implementYield(){
        BigDecimal yield = getBalance().multiply(YIELD);
        addToBalance(yield);
    }

    @Override
    public String toString() {
        return super.toString() + " | Tipo: " + typeAccount;
    }
}
