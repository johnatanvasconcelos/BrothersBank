package br.com.john.brothersbank.controller;

import br.com.john.brothersbank.models.account.entity.Account;
import br.com.john.brothersbank.models.account.dto.AccountDetailsDTO;
import br.com.john.brothersbank.models.checking.dto.CheckingAccountRequestDTO;
import br.com.john.brothersbank.models.checking.dto.CheckingAccountResponseDTO;
import br.com.john.brothersbank.models.checking.dto.CheckingAccountUpdateDTO;
import br.com.john.brothersbank.models.checking.entity.CheckingAccount;
import br.com.john.brothersbank.models.checking.mapper.CheckingAccountMapper;
import br.com.john.brothersbank.models.checking.service.CheckingAccountService;
import br.com.john.brothersbank.models.savings.service.SavingsAccountService;
import br.com.john.brothersbank.models.savings.dto.SavingsAccountUpdateDTO;
import br.com.john.brothersbank.models.savings.entity.SavingsAccount;
import br.com.john.brothersbank.models.savings.dto.SavingsAccountRequestDTO;
import br.com.john.brothersbank.models.savings.dto.SavingsAccountResponseDTO;
import br.com.john.brothersbank.models.account.service.AccountService;
import br.com.john.brothersbank.models.savings.mapper.SavingsAccountMapper;
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
    private SavingsAccountService savingsAccountService;

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

    @PutMapping("savings/{id}")
    public ResponseEntity<SavingsAccountResponseDTO> update(@PathVariable Long id, @RequestBody SavingsAccountUpdateDTO updateDTO){
        SavingsAccount savingsAccount = savingsAccountService.updateAccount(id, updateDTO);
        SavingsAccountResponseDTO responseDTO = savingsAccountMapper.toDTO(savingsAccount);
        return ResponseEntity.ok(responseDTO);
    }
}

