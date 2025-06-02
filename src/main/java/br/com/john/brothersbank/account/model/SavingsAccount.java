package br.com.john.brothersbank.account.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "savings_account")
public class SavingsAccount extends BankAccount {
    public static final BigDecimal YIELD = new BigDecimal("0.005");

    public void implementYield(){
        BigDecimal yield = getBalance().multiply(YIELD);
        addToBalance(yield);
    }
}
