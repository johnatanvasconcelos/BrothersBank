package br.com.john.brothersbank.models.checking;

import br.com.john.brothersbank.models.account.AccountUpdateDTO;
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
