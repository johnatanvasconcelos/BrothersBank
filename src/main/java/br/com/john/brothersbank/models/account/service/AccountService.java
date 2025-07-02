package br.com.john.brothersbank.models.account.service;

import br.com.john.brothersbank.exception.InsufficientFundsException;
import br.com.john.brothersbank.models.account.dto.AccountDetailsDTO;
import br.com.john.brothersbank.models.account.dto.TransferResponseDTO;
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
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository repository;

    @Autowired
    private CheckingAccountMapper checkingAccountMapper;

    @Autowired
    private SavingsAccountMapper savingsAccountMapper;

    public Account getAccountById(Long id){
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Conta não encontrada"));
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

    @Transactional
    public Account performDeposit(Long accountId, BigDecimal amount){

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O valor do depósito deve ser maior que zero");
        }

        Optional<Account> optionalAccount = repository.findById(accountId);

        if (optionalAccount.isEmpty()) {
            throw new IllegalArgumentException("Conta não encontrada com o id " + accountId);
        }

        Account account = optionalAccount.get();

        if(!account.getActive()){
            throw new IllegalArgumentException("Esta conta está desativada");
        }

        account.setBalance(account.getBalance().add(amount));

        return repository.save(account);
    }

    @Transactional
    public Account performWithdrawal(Long accountId, BigDecimal amount) {

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O valor do saque deve ser maior que zero");
        }

        Optional<Account> optionalAccount = repository.findById(accountId);

        if (optionalAccount.isEmpty()) {
            throw new IllegalArgumentException("Conta não encontrada com o id " + accountId);
        }

        Account account = optionalAccount.get();

        if(!account.getActive()){
            throw new IllegalArgumentException("Esta conta está desativada");
        }

        if (account.getBalance().compareTo(amount) < 0) {
            throw new InsufficientFundsException("Saldo insuficiente na conta.");
        }

        account.setBalance(account.getBalance().subtract(amount));

        return repository.save(account);
    }

    @Transactional
    public TransferResponseDTO performTransfer(Long sourceAccountId, Long destinationAccountId, BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O valor da transferência deve ser maior que zero.");
        }
        if (sourceAccountId.equals(destinationAccountId)) {
            throw new IllegalArgumentException("Conta de origem e destino não podem ser as mesmas.");
        }

        Account sourceAccount = repository.findById(sourceAccountId)
                .orElseThrow(() -> new IllegalArgumentException("Conta de origem não encontrada"));
        Account destinationAccount = repository.findById(destinationAccountId)
                .orElseThrow(() -> new IllegalArgumentException("Conta de destino não encontrada"));

        if (sourceAccount.getBalance().compareTo(amount) < 0) {
            throw new InsufficientFundsException("Saldo insuficiente na conta de origem.");
        }

        if(!sourceAccount.getActive()){
            throw new IllegalArgumentException("A conta de origem está desativada");
        }

        if(!destinationAccount.getActive()){
            throw new IllegalArgumentException("A conta de destino está desativada");
        }

        sourceAccount.setBalance(sourceAccount.getBalance().subtract(amount));
        Account updateSourceAccount = repository.save(sourceAccount);

        destinationAccount.setBalance(destinationAccount.getBalance().add(amount));
        Account updateDestinationAccount = repository.save(destinationAccount);

        // Convertendo as contas atualizadas para AccountDetailsDTO
        AccountDetailsDTO sourceDetails = new AccountDetailsDTO(updateSourceAccount);
        AccountDetailsDTO destinationDetails = new AccountDetailsDTO(updateDestinationAccount);

        return new TransferResponseDTO(sourceDetails, destinationDetails);
    }


}