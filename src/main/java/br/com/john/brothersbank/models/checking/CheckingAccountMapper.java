package br.com.john.brothersbank.models.checking;


import br.com.john.brothersbank.models.account.Account;
import br.com.john.brothersbank.models.account.AccountType;
import br.com.john.brothersbank.models.account.AccountUpdateDTO;
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
        entity.setAccountType((AccountType.CHECKING));
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

    public void updateEntity(CheckingAccount entity, CheckingAccountUpdateDTO dto){
        if (dto.getOwnerName() != null && !dto.getOwnerName().trim().isEmpty()){
            entity.setOwnerName(dto.getOwnerName());
        }

        if (dto.getOverdraftLimit() != null) {
            entity.setOverdraftLimit(dto.getOverdraftLimit());
        }
    }
}
