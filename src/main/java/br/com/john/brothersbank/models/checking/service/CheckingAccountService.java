package br.com.john.brothersbank.models.checking.service;

import br.com.john.brothersbank.models.checking.mapper.CheckingAccountMapper;
import br.com.john.brothersbank.models.checking.dto.CheckingAccountUpdateDTO;
import br.com.john.brothersbank.models.checking.entity.CheckingAccount;
import br.com.john.brothersbank.models.checking.repository.CheckingAccountRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckingAccountService {

    @Autowired
    private CheckingAccountMapper mapper;

    @Autowired
    private CheckingAccountRepository repository;

    @Transactional
    public CheckingAccount updateAccount(Long id, CheckingAccountUpdateDTO updateDTO){
        CheckingAccount existingAccount = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Conta não encontrada"));

        if(!existingAccount.getActive()){
            throw new IllegalArgumentException("Esta conta está desativada");
        }

        mapper.updateEntity(existingAccount, updateDTO);

        return repository.save(existingAccount);
    }
}
