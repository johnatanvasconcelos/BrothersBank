package br.com.john.brothersbank.model.savings.dto;

import java.math.BigDecimal;

public record SavingsAccountResponseDTO(
        Long id,
        String accountNumber,
        BigDecimal balance,
        String ownerName,
        Long ownerId,
        BigDecimal interestRate) {
}
