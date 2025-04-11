package br.com.john.brothersbank.models;

import br.com.john.brothersbank.exception.InsufficientFundsException;

import java.math.BigDecimal;

public class CheckingAccount extends BankAccount{
    public static final BigDecimal MAINTENANCE_FEE = new BigDecimal("10.00");
    private static final String typeAccount = "Conta Corrente";


    public CheckingAccount(String ownerName) {
        super(ownerName);
    }

    public void collectMaintenanceCharge(){
        if (getBalance().compareTo(MAINTENANCE_FEE) >= 0){
            subtractFromBalance(MAINTENANCE_FEE);
        }else {
            throw new InsufficientFundsException("Saldo insuficiente para coletar a taxa de manutenção.");
        }
    }

    @Override
    public String toString() {
        return super.toString() + " | Tipo: " + typeAccount;
    }
}
