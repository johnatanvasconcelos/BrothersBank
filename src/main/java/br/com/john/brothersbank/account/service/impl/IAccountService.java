package br.com.john.brothersbank.account.service.impl;

import br.com.john.brothersbank.account.model.BankAccount;

import java.util.List;
import java.util.Optional;

public interface IAccountService {
    BankAccount createAccount(BankAccount account);
    Optional<BankAccount> getAccountById(Long id);
    List<BankAccount> getAllAccounts();
    void deleteAccount(Long id);
}
