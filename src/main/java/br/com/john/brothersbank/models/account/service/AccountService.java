package br.com.john.brothersbank.models.account.service;

import br.com.john.brothersbank.models.account.entity.Account;
import br.com.john.brothersbank.models.account.repository.AccountRepository;
import br.com.john.brothersbank.models.checking.entity.CheckingAccount;
import br.com.john.brothersbank.models.checking.dto.CheckingAccountRequestDTO;
import br.com.john.brothersbank.models.checking.mapper.CheckingAccountMapper;
import br.com.john.brothersbank.models.savings.entity.SavingsAccount;
import br.com.john.brothersbank.models.savings.dto.SavingsAccountRequestDTO;
import br.com.john.brothersbank.models.savings.mapper.SavingsAccountMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountService {

    @Autowired
    private AccountRepository repository;

    @Autowired
    private CheckingAccountMapper checkingAccountMapper;

    @Autowired
    private SavingsAccountMapper savingsAccountMapper;

    @Transactional
    public Account performWithdrawal(Long id, BigDecimal amount) {
        Account account = getAccountById(id);
        account.withdraw(amount);

        return repository.save(account);
    }

    public Account getAccountById(Long id){
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Conta não encontrada"));
    }

    @Transactional
    public void performTransfer(Long sourceId, Long targetId, BigDecimal amount){
        if (amount.compareTo(BigDecimal.ZERO) <= 0) throw new IllegalArgumentException("O valor da transferência deve ser maior que zero");

        Account sourceAccount = getAccountById(sourceId);
        Account targetAccount = getAccountById(targetId);

        if (sourceAccount instanceof SavingsAccount){
            throw new UnsupportedOperationException("Conta poupança não pode realizar transferência");
        }

        sourceAccount.withdraw(amount);
        targetAccount.deposit(amount);

        repository.save(sourceAccount);
        repository.save(targetAccount);
    }

    @Transactional
    public CheckingAccount createCheckingAccount(CheckingAccountRequestDTO dto){
        CheckingAccount checkingAccount = checkingAccountMapper.toEntity(dto);
        return repository.save(checkingAccount);
    }

    @Transactional
    public SavingsAccount createSavingsAccount(SavingsAccountRequestDTO dto){
        SavingsAccount savingsAccount = savingsAccountMapper.toEntity(dto);
        return repository.save(savingsAccount);
    }

    public Page<Account> listActiveAccounts(Pageable pageable){
        return repository.findAllByActiveTrue(pageable);
    }

    @Transactional
    public Account deactivateAccount(Long id) {
        Account account = getAccountById(id);
        account.setActive(false);
        return repository.save(account);
    }
}
