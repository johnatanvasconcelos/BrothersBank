package br.com.john.brothersbank.controller;

import br.com.john.brothersbank.models.account.Account;
import br.com.john.brothersbank.models.account.AccountDetailsDTO;
import br.com.john.brothersbank.models.account.AccountUpdateDTO;
import br.com.john.brothersbank.models.checking.*;
import br.com.john.brothersbank.models.savings.SavingsAccount;
import br.com.john.brothersbank.models.savings.SavingsAccountRequestDTO;
import br.com.john.brothersbank.models.savings.SavingsAccountResponseDTO;
import br.com.john.brothersbank.models.savings.SavingsAccountMapper;
import br.com.john.brothersbank.models.account.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private CheckingAccountService checkingAccountService;

    @Autowired
    private CheckingAccountMapper checkingAccountMapper;

    @Autowired
    private SavingsAccountMapper savingsAccountMapper;

    @PostMapping("/checking")
    public ResponseEntity<CheckingAccountResponseDTO> openCheckingAccount(@Valid @RequestBody CheckingAccountRequestDTO requestDTO){
        CheckingAccount createdAccount = accountService.createCheckingAccount(requestDTO);
        CheckingAccountResponseDTO responseDTO = checkingAccountMapper.toDTO(createdAccount);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PostMapping("/savings")
    public ResponseEntity<SavingsAccountResponseDTO> openSavingsAccount(@Valid @RequestBody SavingsAccountRequestDTO requestDTO){
        SavingsAccount createdAccount = accountService.createSavingsAccount(requestDTO);
        SavingsAccountResponseDTO responseDTO = savingsAccountMapper.toDTO(createdAccount);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDetailsDTO> getAccountDetails(@PathVariable Long id){
        Account account = accountService.getAccountById(id);
        return ResponseEntity.ok(new AccountDetailsDTO(account));
    }

    @GetMapping
    public ResponseEntity<Page<AccountDetailsDTO>> listActiveAccounts(@PageableDefault(size = 10, sort = {"ownerName"}) Pageable pageable){
        Page<Account> page = accountService.listActiveAccounts(pageable);
        Page<AccountDetailsDTO> activeAccountsDTOPage = page.map(AccountDetailsDTO::new);
        return ResponseEntity.ok(activeAccountsDTOPage);
    }

    @PutMapping("checking/{id}")
    public ResponseEntity<CheckingAccountResponseDTO> update(@PathVariable Long id, @RequestBody CheckingAccountUpdateDTO updateDTO){
        CheckingAccount updatedAccount = checkingAccountService.updateAccount(id, updateDTO);

        CheckingAccountResponseDTO responseDTO = checkingAccountMapper.toDTO(updatedAccount);

        return ResponseEntity.ok(responseDTO);

    }
}

