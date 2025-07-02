package br.com.john.brothersbank.models.account.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record TransferRequestDTO(
        @NotNull(message = "O ID da conta de origem é obrigatório.")
        Long sourceAccountId,
        @NotNull(message = "O ID da conta de destino é obrigatório.")
        Long destinationAccountId,
        @NotNull(message = "O valor da transferência é obrigatório.")
        BigDecimal amount
) {
}
