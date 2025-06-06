package br.com.john.brothersbank.models.checking;

import java.math.BigDecimal;

public record CheckingAccountResponseDTO(
        Long id,
        String accountNumber,
        BigDecimal balance,
        String ownerName,
        Long ownerId,
        BigDecimal overdraftLimit) {
}
