package com.meuprojeto.brothersbank.service.impl;

import com.meuprojeto.brothersbank.models.BankAccount;
import com.meuprojeto.brothersbank.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AccountServiceImpl implements AccountService {
    private final Map<Long, BankAccount> accounts = new HashMap<>();
    private final Set<Long> generatedIds = new HashSet<>();
    private final Random random = new Random();
    private long nextId = 1;

    @Override
    public BankAccount createAccount(BankAccount account) {
        account.setId(nextId++);
        account.setAccountNumber(generateUniqueAccountId());
        accounts.put(account.getId(), account);
        return account;
    }

    private long generateUniqueAccountId() {
        long accountNumber;
        do {
            long fiveDigitNumber = 10000 + random.nextInt(90000);
            int extraDigit = random.nextInt(10);
            accountNumber = Long.parseLong(fiveDigitNumber + "" + extraDigit);
        } while (generatedIds.contains(accountNumber));

        generatedIds.add(accountNumber);
        return accountNumber;
    }

    @Override
    public Optional<BankAccount> getAccountById(Long id) {
        return Optional.ofNullable(accounts.get(id));
    }

    @Override
    public List<BankAccount> getAllAccounts() {
        return new ArrayList<>(accounts.values());
    }

    @Override
    public void deleteAccount(Long id) {
        accounts.remove(id);
    }
}
