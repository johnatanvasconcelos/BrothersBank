package br.com.john.brothersbank.models.savings.dto;

import br.com.john.brothersbank.models.account.dto.AccountUpdateDTO;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class SavingsAccountUpdateDTO extends AccountUpdateDTO {
    private BigDecimal interestRate;

    public SavingsAccountUpdateDTO(){}

    public SavingsAccountUpdateDTO(String ownerName, BigDecimal interestRate){
        super(ownerName);
        this.interestRate = interestRate;
    }
}
