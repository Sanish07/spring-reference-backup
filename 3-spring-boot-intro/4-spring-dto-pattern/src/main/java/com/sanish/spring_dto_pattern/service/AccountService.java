package com.sanish.spring_dto_pattern.service;

import com.sanish.spring_dto_pattern.entity.Account;

import java.util.List;

public interface AccountService {
    Account getAccById(int id);

    List<Account> getAllAcc();

    Account addNewAccount(Account account);
}
