package br.com.john.brothersbank.account.service;

import br.com.john.brothersbank.account.model.BankAccount;
import br.com.john.brothersbank.account.service.impl.IAccountNumberGenerator;
import br.com.john.brothersbank.account.service.impl.IAccountService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AccountServiceImpl implements IAccountService {
    private final Map<Long, BankAccount> accounts = new HashMap<>();
    private final Set<Long> generatedIds = new HashSet<>();
    private final Random random = new Random();
    private long nextInternalId = 1;
    private final IAccountNumberGenerator numberGenerator;

    public AccountServiceImpl(IAccountNumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    @Override
    public BankAccount createAccount(BankAccount account) {
        account.setId(nextInternalId++);
        account.setAccountNumber(numberGenerator.generate());
        accounts.put(account.getId(), account);
        return account;
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
