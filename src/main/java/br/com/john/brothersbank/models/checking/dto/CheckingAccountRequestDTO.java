package br.com.john.brothersbank.models.checking.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CheckingAccountRequestDTO(

        @NotBlank
        String accountNumber,
        @NotNull
        BigDecimal initialBalance,
        @NotBlank
        String ownerName,
        @NotNull
        Long ownerId,
        @NotNull
        BigDecimal overdraftLimit
) {
}
