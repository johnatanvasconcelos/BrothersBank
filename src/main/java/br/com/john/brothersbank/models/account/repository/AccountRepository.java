package br.com.john.brothersbank.models.account.repository;

import br.com.john.brothersbank.models.account.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Page<Account> findAllByActiveTrue(Pageable pageable);
}
