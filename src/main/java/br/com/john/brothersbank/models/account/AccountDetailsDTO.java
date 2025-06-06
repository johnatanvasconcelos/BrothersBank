package br.com.john.brothersbank.models.account;

import java.math.BigDecimal;

public record AccountDetailsDTO(
        Long id,
        String accountNumber,
        BigDecimal balance,
        String ownerName,
        Long ownerId,
        Boolean active,
        String accountType
) {
    public AccountDetailsDTO(Account account){
        this(account.getId(),
                account.getAccountNumber(),
                account.getBalance(),
                account.getOwnerName(),
                account.getOwnerId(),
                account.getActive(),
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
}
