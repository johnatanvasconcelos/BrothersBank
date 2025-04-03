package com.meuprojeto.brothersbank.service.impl;

import com.meuprojeto.brothersbank.exception.InsufficientFundsException;
import com.meuprojeto.brothersbank.models.BankAccount;
import com.meuprojeto.brothersbank.service.BankService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class BankServiceImpl implements BankService {

    private static final int SCALE = 2;

    @Override
    public void deposit(BankAccount account, BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("Valor de depósito inválido");
        }
        account.setBalance(
                account.getBalance()
                        .add(amount)
                        .setScale(SCALE, RoundingMode.HALF_UP)
        );
    }

    @Override
    public void withdraw(BankAccount account, BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor de saque inválido");
        }
        if (account.getBalance().compareTo(amount) < 0){
            throw new InsufficientFundsException("Saldo insuficiente");
        }
        account.setBalance(
                account.getBalance()
                        .subtract(amount)
                        .setScale(SCALE, RoundingMode.HALF_UP)
        );
    }

    @Override
    public void transfer(BankAccount originAccount, BankAccount destinationAccount, BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("Valor de transferência inválido");
        }

        withdraw(originAccount, amount);
        deposit(destinationAccount, amount);
    }
}
