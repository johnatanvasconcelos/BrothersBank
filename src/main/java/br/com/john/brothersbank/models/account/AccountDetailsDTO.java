package br.com.john.brothersbank.dto;

import br.com.john.brothersbank.model.Account;

import java.math.BigDecimal;

public record AccountDetailsDTO(
        Long id,
        String accountNumber,
        BigDecimal balance,
        String ownerName,
        Long ownerId
) {
    public AccountDetailsDTO(Account account){
        this(account.getId(),
                account.getAccountNumber(),
                account.getBalance(),
                account.getOwnerName(),
                account.getOwnerId());
    }
}
