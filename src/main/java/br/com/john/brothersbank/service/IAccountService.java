package br.com.john.brothersbank.service;

import br.com.john.brothersbank.models.BankAccount;

import java.util.List;
import java.util.Optional;

public interface IAccountService {
    BankAccount createAccount(BankAccount account);
    Optional<BankAccount> getAccountById(Long id);
    List<BankAccount> getAllAccounts();
    void deleteAccount(Long id);
}
