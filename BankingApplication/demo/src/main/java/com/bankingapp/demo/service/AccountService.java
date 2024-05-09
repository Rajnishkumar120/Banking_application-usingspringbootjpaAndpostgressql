package com.bankingapp.demo.service;

import java.util.List;

import com.bankingapp.demo.dto.AccountDto;

public interface AccountService {
    
    AccountDto createAccount(AccountDto accountDto);

    AccountDto  getAcountById(Long id);

    AccountDto deposite(Long id,double amount);

    AccountDto withdraw(Long id, double amount);
    List<AccountDto>  getAllAccounts();

    void deleteAcount(Long id);
}
