package br.com.john.brothersbank.model.checking.mappers;


import br.com.john.brothersbank.model.checking.CheckingAccount;
import br.com.john.brothersbank.model.checking.dto.CheckingAccountRequestDTO;
import br.com.john.brothersbank.model.checking.dto.CheckingAccountResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class CheckingAccountMapper {

    // Mapeando de DTO de criação para Entity
    public CheckingAccount toEntity(CheckingAccountRequestDTO dto){
        if (dto == null){
            return null;
        }
        CheckingAccount entity = new CheckingAccount();
        entity.setAccountNumber(dto.accountNumber());
        entity.setBalance(dto.initialBalance());
        entity.setOwnerName(dto.ownerName());
        entity.setOwnerId(dto.ownerId());
        entity.setOverdraftLimit(dto.overdraftLimit());
        return entity;
    }

    // Mapeando de Entity para DTO de resposta
    public CheckingAccountResponseDTO toDTO(CheckingAccount entity){
        if (entity == null){
            return null;
        }
        return new CheckingAccountResponseDTO(
                entity.getId(),
                entity.getAccountNumber(),
                entity.getBalance(),
                entity.getOwnerName(),
                entity.getOwnerId(),
                entity.getOverdraftLimit()
        );
    }
}
