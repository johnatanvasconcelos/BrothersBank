package br.com.john.brothersbank.models.savings.mapper;

import br.com.john.brothersbank.models.account.entity.AccountType;
import br.com.john.brothersbank.models.savings.dto.SavingsAccountRequestDTO;
import br.com.john.brothersbank.models.savings.dto.SavingsAccountResponseDTO;
import br.com.john.brothersbank.models.savings.dto.SavingsAccountUpdateDTO;
import br.com.john.brothersbank.models.savings.entity.SavingsAccount;
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
        entity.setActive(true);
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
                entity.getActive() ? "Ativa" : "Inativa",
                entity.getInterestRate()
        );
    }

    public void updateEntity(SavingsAccount entity, SavingsAccountUpdateDTO dto){
        if (dto.getOwnerName() != null && !dto.getOwnerName().trim().isEmpty()){
            entity.setOwnerName(dto.getOwnerName());
        }
        if (dto.getInterestRate() != null) {
            entity.setInterestRate(dto.getInterestRate());
        }
    }
}
