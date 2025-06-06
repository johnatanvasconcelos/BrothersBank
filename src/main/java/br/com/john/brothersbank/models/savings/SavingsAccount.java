package br.com.john.brothersbank.model.savings;

import br.com.john.brothersbank.model.Account;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
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

    @Override
    public void withdraw(BigDecimal amount) {
        if (this.balance.compareTo(amount) >= 0) {
            this.balance = this.balance.subtract(amount);
        } else {
            throw new IllegalArgumentException("Saldo insuficiente");
        }
    }
}
