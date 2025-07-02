package br.com.john.brothersbank.models.account.dto;

public record TransferResponseDTO(
        AccountDetailsDTO sourceAccount,
        AccountDetailsDTO destinationAccount
) {
}
