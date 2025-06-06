package br.com.john.brothersbank.model.checking.dto;

import java.math.BigDecimal;

public record CheckingAccountResponseDTO(
        Long id,
        String accountNumber,
        BigDecimal balance,
        String ownerName,
        Long ownerId,
        BigDecimal overdraftLimit) {
}
