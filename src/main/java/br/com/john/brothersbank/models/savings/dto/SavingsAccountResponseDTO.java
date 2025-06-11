package br.com.john.brothersbank.models.savings.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public record SavingsAccountResponseDTO(
        Long id,
        String accountNumber,
        BigDecimal balance,
        String ownerName,
        Long ownerId,
        @JsonProperty("status")
        String active,
        BigDecimal interestRate) {
}
