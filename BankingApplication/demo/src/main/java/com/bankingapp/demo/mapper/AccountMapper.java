package com.bankingapp.demo.mapper;

import com.bankingapp.demo.dto.AccountDto;
import com.bankingapp.demo.entity.Account;

public class AccountMapper {
    public static Account maptoAccount(AccountDto accountDto)
    {
        Account account=  new Account(
            accountDto.getId(),
            accountDto.getAccountHolderName(),
            accountDto.getBalance()


        );
        return account;
    }

    public static AccountDto maptoAccountdDto(Account account)
    {
        AccountDto accountdto= new AccountDto(
            account.getId(),
            account.getAccountHolderName(),
            account.getBalance()
        );
        return accountdto;
    }
  
    
}
