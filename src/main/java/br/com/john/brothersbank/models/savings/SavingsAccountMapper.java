package br.com.john.brothersbank.models.savings;

import br.com.john.brothersbank.models.account.AccountType;
import org.springframework.stereotype.Component;

@Component
public class SavingsAccountMapper {
    // Mapeando de DTO de criação para Entity
    public SavingsAccount toEntity(SavingsAccountRequestDTO dto){
        if (dto == null){
            return null;
        }
        SavingsAccount entity = new SavingsAccount();
        entity.setAccountNumber(dto.accountNumber());
        entity.setBalance(dto.initialBalance());
        entity.setOwnerName(dto.ownerName());
        entity.setOwnerId(dto.ownerId());
        entity.setInterestRate(dto.interestRate());
        entity.setAccountType((AccountType.SAVINGS));
        return entity;
    }

    // Mapeando de Entity para DTO de resposta
    public SavingsAccountResponseDTO toDTO(SavingsAccount entity){
        if (entity == null){
            return null;
        }
        return new SavingsAccountResponseDTO(
                entity.getId(),
                entity.getAccountNumber(),
                entity.getBalance(),
                entity.getOwnerName(),
                entity.getOwnerId(),
                entity.getInterestRate()
        );
    }
}
