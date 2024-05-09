package com.bankingapp.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.bankingapp.demo.dto.AccountDto;
import com.bankingapp.demo.entity.Account;
import com.bankingapp.demo.mapper.AccountMapper;
import com.bankingapp.demo.repository.AccountRepository;
import com.bankingapp.demo.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {

        Account account = AccountMapper.maptoAccount(accountDto);
        Account SavedAccount = accountRepository.save(account);

        return AccountMapper.maptoAccountdDto(SavedAccount);
    }

    @Override
    public AccountDto getAcountById(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account does not exit "));
        return AccountMapper.maptoAccountdDto(account);

    }

    @Override
    public AccountDto deposite(Long id, double amount) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account does not exit "));
        double total = account.getBalance() + amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);

        return AccountMapper.maptoAccountdDto(savedAccount);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {

        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account does not exit "));

        if (account.getBalance() < amount) {
            throw new RuntimeException("insuffiecient balance ");
        }

        double total = account.getBalance() - amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);

        return AccountMapper.maptoAccountdDto(savedAccount);

    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream()
                .map(account -> AccountMapper.maptoAccountdDto(account))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAcount(Long id) {

        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account does not exit "));
        accountRepository.deleteById(id);
    }

}
