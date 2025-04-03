package com.meuprojeto.brothersbank.service;

import com.meuprojeto.brothersbank.exception.InsufficientFundsException;
import com.meuprojeto.brothersbank.models.BankAccount;

import java.math.BigDecimal;

public interface BankService {
    void transfer(BankAccount originAccount, BankAccount destinationAccount, BigDecimal amount);
    void deposit(BankAccount account, BigDecimal amount);
    void withdraw(BankAccount account, BigDecimal amount);
}
