package br.com.john.brothersbank.controller;

import br.com.john.brothersbank.model.checking.CheckingAccount;
import br.com.john.brothersbank.model.checking.dto.CheckingAccountRequestDTO;
import br.com.john.brothersbank.model.checking.dto.CheckingAccountResponseDTO;
import br.com.john.brothersbank.model.checking.mappers.CheckingAccountMapper;
import br.com.john.brothersbank.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private CheckingAccountMapper checkingAccountMapper;

    @PostMapping("/checking")
    public ResponseEntity<CheckingAccountResponseDTO> openCheckingAccount(@Valid @RequestBody CheckingAccountRequestDTO requestDTO){
        CheckingAccount createdAccount = accountService.createCheckingAccount(requestDTO);
        CheckingAccountResponseDTO responseDTO = checkingAccountMapper.toDTO(createdAccount);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }
}

