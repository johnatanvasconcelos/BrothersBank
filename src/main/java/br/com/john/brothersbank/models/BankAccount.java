package br.com.john.brothersbank.models;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class BankAccount {
    private Long id;
    private Long accountNumber;
    private final String ownerName;
    private BigDecimal balance;

    public BankAccount(String ownerName) {
        this.ownerName = ownerName;
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getFormattedAccountNumber(){
        String number = String.format("%06d", this.accountNumber);
        String base = number.substring(0, 5);
        String digit = number.substring(5);

        return base + "-" + digit;
    }

    @Override
    public String toString() {
        return "Número da conta: " +
                getFormattedAccountNumber() +
                " | " +
                "Proprietário: "
                + getOwnerName() +
                " | ";
    }
}
