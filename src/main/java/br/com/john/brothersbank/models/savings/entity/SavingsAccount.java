package br.com.john.brothersbank.models.savings.entity;

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
@Table(name = "savings_accounts")
public class SavingsAccount extends Account {

    private BigDecimal interestRate = new BigDecimal("0.005");
}
