package br.com.john.brothersbank.config;

import br.com.john.brothersbank.models.BankAccount;
import br.com.john.brothersbank.models.CheckingAccount;
import br.com.john.brothersbank.models.SavingsAccount;
import br.com.john.brothersbank.service.IAccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class StartupRunner implements CommandLineRunner {

    private final IAccountService accountService;

    public StartupRunner(IAccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void run(String... args) throws Exception {
        BankAccount accountOne =
                accountService.createAccount(
                        new SavingsAccount("João Silva")
                );
        BankAccount accountTwo =
                accountService.createAccount(
                        new CheckingAccount("José Souza")
                );

        System.out.println(accountOne);
        System.out.println(accountTwo);

    }
}
