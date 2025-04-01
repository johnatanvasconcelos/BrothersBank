package com.meuprojeto.brothersbank.service;

import com.meuprojeto.brothersbank.models.BankAccount;

public class ServicesBank {

    public void transfer(BankAccount originAccount, BankAccount destinationAccount, double value){
        if (originAccount == null || destinationAccount == null){
            throw new IllegalArgumentException("Conta de origem ou destino não encontrada");
        }
        originAccount.withdraw(value);
        destinationAccount.deposit(value);
    }
}
