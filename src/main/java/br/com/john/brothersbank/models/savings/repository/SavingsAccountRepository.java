package br.com.john.brothersbank.models.savings.repository;

import br.com.john.brothersbank.models.savings.entity.SavingsAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavingsAccountRepository extends JpaRepository<SavingsAccount, Long> {
}
