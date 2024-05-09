package com.bankingapp.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankingapp.demo.entity.Account;

public interface AccountRepository extends JpaRepository<Account,Long> {
    
    

    
}
