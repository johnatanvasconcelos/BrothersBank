package br.com.john.brothersbank.models.savings.service;

import br.com.john.brothersbank.models.savings.dto.SavingsAccountUpdateDTO;
import br.com.john.brothersbank.models.savings.entity.SavingsAccount;
import br.com.john.brothersbank.models.savings.mapper.SavingsAccountMapper;
import br.com.john.brothersbank.models.savings.repository.SavingsAccountRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SavingsAccountService {

    @Autowired
    private SavingsAccountRepository repository;

    @Autowired
    private SavingsAccountMapper mapper;

    @Transactional
    public SavingsAccount updateAccount(Long id, SavingsAccountUpdateDTO updateDTO) {
        SavingsAccount existingAccount = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Conta não encontrada"));

        if(!existingAccount.getActive()){
            throw new IllegalArgumentException("Esta conta está desativada");
        }

        mapper.updateEntity(existingAccount, updateDTO);

        return repository.save(existingAccount);

    }
}
