package br.com.john.brothersbank.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_number", unique = true)
    private String accountNumber;

    protected BigDecimal balance;

    @Column(name = "owner_name")
    private String ownerName;

    @Column(name = "owner_id")
    private Long ownerId;

    public abstract void withdraw (BigDecimal amount);

    public void deposit(BigDecimal amount){
        if (amount.compareTo(BigDecimal.ZERO) <= 0) throw new IllegalArgumentException("O valor do depósito deve ser maior que zero");
        this.balance = this.balance.add(amount);
    }
}
