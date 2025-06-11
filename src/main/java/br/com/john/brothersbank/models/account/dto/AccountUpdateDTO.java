package br.com.john.brothersbank.models.account.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AccountUpdateDTO{
        private String ownerName;

        public AccountUpdateDTO(){}

        public AccountUpdateDTO(String ownerName){
                this.ownerName = ownerName;
        }

}

