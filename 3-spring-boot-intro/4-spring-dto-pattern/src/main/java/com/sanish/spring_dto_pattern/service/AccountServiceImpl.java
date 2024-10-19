package com.sanish.spring_dto_pattern.service;

import com.sanish.spring_dto_pattern.entity.Account;
import com.sanish.spring_dto_pattern.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account getAccById(int id) {
        return accountRepository.findById(id).orElse(null);
    }

    @Override
    public List<Account> getAllAcc() {
        return accountRepository.findAll();
    }

    @Override
    @Transactional
    public Account addNewAccount(Account account) {
        return accountRepository.save(account);
    }
}
