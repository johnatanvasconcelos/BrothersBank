package br.com.john.brothersbank.models.account.dto;

import br.com.john.brothersbank.models.account.entity.AccountType;
import br.com.john.brothersbank.models.account.entity.Account;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public record AccountDetailsDTO(
        @JsonProperty("ID da conta")
        Long id,
        @JsonProperty("Número da Conta")
        String accountNumber,
        @JsonProperty("Saldo da Conta")
        BigDecimal balance,
        @JsonProperty("Nome do titular")
        String ownerName,
        @JsonProperty("ID do titular")
        Long ownerId,
        @JsonProperty("Status da Conta")
        String active,
        @JsonProperty("Tipo da Conta")
        String accountType
) {
    public AccountDetailsDTO(Account account){
        this(account.getId(),
                account.getAccountNumber(),
                account.getBalance(),
                account.getOwnerName(),
                account.getOwnerId(),
                mapActiveToStatus(account.getActive()),
                mapAccountTypeToDisplayString(account.getAccountType()));
    }

    private static String mapAccountTypeToDisplayString(AccountType accountType) {
        if (accountType == null){
            return "Tipo desconhecido";
        }
        return switch (accountType){
            case CHECKING -> "Conta Corrente";
            case SAVINGS -> "Conta poupança";
            default -> "Tipo desconhecido";
        };
    }

    private static String mapActiveToStatus(Boolean active){
        return active ? "Ativa" : "Inativa";
    }
}
