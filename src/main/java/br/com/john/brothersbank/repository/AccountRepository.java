package br.com.john.brothersbank.repository;

import br.com.john.brothersbank.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {


}
