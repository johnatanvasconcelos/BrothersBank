package com.meuprojeto.brothersbank.service;

import com.meuprojeto.brothersbank.models.BankAccount;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    BankAccount createAccount(BankAccount account);
    Optional<BankAccount> getAccountById(Long id);
    List<BankAccount> getAllAccounts();
    void deleteAccount(Long id);
}
