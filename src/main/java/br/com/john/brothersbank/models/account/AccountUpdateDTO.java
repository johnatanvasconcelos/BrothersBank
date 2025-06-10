package br.com.john.brothersbank.models.account;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public abstract class AccountUpdateDTO{
        private String ownerName;

        public AccountUpdateDTO(){}

        public AccountUpdateDTO(String ownerName){
                this.ownerName = ownerName;
        }

}

