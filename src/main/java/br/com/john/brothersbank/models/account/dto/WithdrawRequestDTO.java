package br.com.john.brothersbank.models.account.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record WithdrawRequestDTO(
        @NotNull(message = "O valor do saque é obrigatório.")
        BigDecimal amount
) {
}
