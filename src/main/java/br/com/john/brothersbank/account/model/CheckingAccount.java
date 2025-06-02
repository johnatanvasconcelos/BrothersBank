package br.com.john.brothersbank.account.model;

import br.com.john.brothersbank.exception.InsufficientFundsException;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "checking_account")
public class CheckingAccount extends BankAccount {
    public static final BigDecimal MAINTENANCE_FEE = new BigDecimal("10.00");
    private static final AccountType typeAccount = AccountType.CHECKING_ACCOUNT;


    public CheckingAccount(String ownerName) {
        super(ownerName);
    }

    public void collectMaintenanceCharge(){
        if (getBalance().compareTo(MAINTENANCE_FEE) >= 0){
            subtractFromBalance(MAINTENANCE_FEE);
        }else {
            throw new InsufficientFundsException("Saldo insuficiente para coletar a taxa de manutenção.");
        }
    }

    @Override
    public String toString() {
        return super.toString() + " | Tipo: " + typeAccount;
    }
}
