package br.com.john.brothersbank.models.checking.entity;

import br.com.john.brothersbank.models.account.entity.Account;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "checking_accounts")
public class CheckingAccount extends Account {

    private BigDecimal overdraftLimit = new BigDecimal("500.00");
}
