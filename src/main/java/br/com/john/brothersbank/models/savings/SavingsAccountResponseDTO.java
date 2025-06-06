package br.com.john.brothersbank.models.savings;

import java.math.BigDecimal;

public record SavingsAccountResponseDTO(
        Long id,
        String accountNumber,
        BigDecimal balance,
        String ownerName,
        Long ownerId,
        BigDecimal interestRate) {
}
