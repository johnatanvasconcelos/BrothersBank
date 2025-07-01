package br.com.john.brothersbank.models.account.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record DepositRequestDTO(
       @NotNull(message = "O valor do depósito é obrigatório.")
       @Positive(message = "O valor do depósito deve ser positivo.")
       BigDecimal amount
) {
}
