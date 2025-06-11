package br.com.john.brothersbank.models.checking.repository;

import br.com.john.brothersbank.models.checking.entity.CheckingAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckingAccountRepository extends JpaRepository<CheckingAccount, Long> {
}
