package com.meuprojeto.brothersbank.models;

import java.math.BigDecimal;

public class CheckingAccount extends BankAccount{
    public static final BigDecimal MAINTENANCE_FEE = new BigDecimal("10.00");

    public CheckingAccount(String ownerName, BigDecimal balance) {
        super(ownerName, balance);
    }

    public void collectMaintenanceCharge(){
        if (getBalance().compareTo(MAINTENANCE_FEE) >= 0){
            setBalance(getBalance().subtract(MAINTENANCE_FEE));
        }else {
            throw new IllegalArgumentException("Saldo insuficiente para coletar a taxa de manutenção.");
        }
    }
}
