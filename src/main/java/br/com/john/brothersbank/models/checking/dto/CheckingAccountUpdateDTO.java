package br.com.john.brothersbank.models.checking.dto;

import br.com.john.brothersbank.models.account.dto.AccountUpdateDTO;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CheckingAccountUpdateDTO extends AccountUpdateDTO {
    private BigDecimal overdraftLimit;

    public CheckingAccountUpdateDTO(){}

    public CheckingAccountUpdateDTO(String ownerName, BigDecimal overdraftLimit){
        super(ownerName);
        this.overdraftLimit = overdraftLimit;
    }
}
