package com.meuprojeto.brothersbank.service;

import com.meuprojeto.brothersbank.exception.InsufficientFundsException;
import com.meuprojeto.brothersbank.models.BankAccount;

public class ServicesBank {

    public void transfer(BankAccount originAccount, BankAccount destinationAccount, double value){
        if (originAccount == null || destinationAccount == null){
            throw new IllegalArgumentException("Conta de origem ou destino não encontrada");
        }
        if (value <= 0){
            throw new IllegalArgumentException("Valor de transferência inválido." +
                    " O valor deve ser maior que zero.");
        }
        if (originAccount.getBalance() < value){
            throw new InsufficientFundsException("Saldo insuficiente na conta de origem.");
        }
        originAccount.withdraw(value);
        destinationAccount.deposit(value);
    }
}
