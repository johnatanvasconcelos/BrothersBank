package br.com.john.brothersbank.account.repository;

import br.com.john.brothersbank.account.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<BankAccount, Long> {

}
