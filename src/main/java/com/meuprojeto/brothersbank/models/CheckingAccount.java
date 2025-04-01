package com.meuprojeto.brothersbank.models;

public class CheckingAccount extends BankAccount{
    public static final double MAINTENANCE_FEE = 10.0;

    public CheckingAccount(String accountNumber, Double balance) {
        super(accountNumber, balance);
    }

    public void collectMaintenanceCharge(){
        if (getBalance() >= MAINTENANCE_FEE){
            setBalance(getBalance() - MAINTENANCE_FEE);
        }else {
            throw new IllegalArgumentException("Saldo insuficiente para coletar a taxa de manutenção.");
        }
    }
}
