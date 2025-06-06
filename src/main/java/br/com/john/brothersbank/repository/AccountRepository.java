package br.com.john.brothersbank.repository;

import br.com.john.brothersbank.models.account.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Page<Account> findAllByActiveTrue(Pageable pageable);
}
