package br.com.john.brothersbank.models.checking;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckingAccountRepository extends JpaRepository<CheckingAccount, Long> {
}
