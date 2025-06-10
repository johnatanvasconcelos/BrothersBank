package br.com.john.brothersbank.models.checking;

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

        mapper.updateEntity(existingAccount, updateDTO);

        return repository.save(existingAccount);
    }
}
