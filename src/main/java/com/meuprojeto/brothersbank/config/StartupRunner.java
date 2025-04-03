package com.meuprojeto.brothersbank.config;

import com.meuprojeto.brothersbank.models.BankAccount;
import com.meuprojeto.brothersbank.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class StartupRunner implements CommandLineRunner {

    private final AccountService accountService;

    public StartupRunner(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void run(String... args) throws Exception {
        BankAccount accountOne =
                accountService.createAccount(
                        new BankAccount("João Silva", new BigDecimal("60000"))
                );
        BankAccount accountTwo =
                accountService.createAccount(
                        new BankAccount("José Souza", new BigDecimal("40000"))
                );

        System.out.println(accountOne);
        System.out.println(accountTwo);

    }
}
