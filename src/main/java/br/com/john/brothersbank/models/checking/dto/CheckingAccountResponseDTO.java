package br.com.john.brothersbank.models.checking.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public record CheckingAccountResponseDTO(
        Long id,
        String accountNumber,
        BigDecimal balance,
        String ownerName,
        Long ownerId,

        @JsonProperty("status")
        String active,
        BigDecimal overdraftLimit) {
}
