package br.com.john.brothersbank.account.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Entity
@Table(name = "bank_account")
@Getter
@EqualsAndHashCode(of = "id")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_number", unique = true)
    private String accountNumber;

    @Column(name = "agency_number")
    private String agencyNumber;

    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private AccountType typeAccount;

    @Column(name = "owner_name")
    private String ownerName;

    @Column(unique = true)
    private String cpf;

    @Column(name = "daily_withdraw_limit")
    private BigDecimal dailyWithdrawLimit;


    public void deposit(BigDecimal amount){
        validateAmount(amount);
        this.balance = this.balance.add(amount).setScale(2, RoundingMode.HALF_UP);
    }

    public void withdraw(BigDecimal amount){
        validateAmount(amount);
        if (balance.compareTo(amount) < 0){
            throw new IllegalArgumentException("Saldo insuficiente");
        }
        this.balance = this.balance.subtract(amount).setScale(2, RoundingMode.HALF_UP);
    }

    public void transferTo(BankAccount destinationAccount, BigDecimal amount){
        this.withdraw(amount);
        destinationAccount.deposit(amount);
    }

    private void validateAmount(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("Valor inválido");
        }
    }

    protected void addToBalance(BigDecimal amount){
        this.balance = this.balance.add(amount).setScale(2, RoundingMode.HALF_UP);
    }

    protected void subtractFromBalance(BigDecimal amount){
        this.balance = this.balance.subtract(amount).setScale(2, RoundingMode.HALF_UP);
    }
}
