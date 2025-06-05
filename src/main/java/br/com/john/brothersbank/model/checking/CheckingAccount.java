package br.com.john.brothersbank.model.checking;

import br.com.john.brothersbank.model.Account;
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

    @Override
    public void withdraw(BigDecimal amount) {

        if(this.balance.add(this.overdraftLimit).compareTo(amount) >= 0) {
            this.balance = this.balance.subtract(amount);
        } else {
            throw new IllegalArgumentException("Saldo insuficiente");
        }
    }
}
