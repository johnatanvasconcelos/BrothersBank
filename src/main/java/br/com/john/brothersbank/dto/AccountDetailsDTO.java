package br.com.john.brothersbank.dto;

import java.math.BigDecimal;

public record AccountDetailsDTO(
        Long id,
        String accountNumber,
        BigDecimal balance,
        String ownerName,
        String ownerId
) {
}
