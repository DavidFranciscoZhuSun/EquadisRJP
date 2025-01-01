package com.equadis.RJP_bank_system.dao;

import com.equadis.RJP_bank_system.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountMapper extends JpaRepository<Account, Long> {
    List<Account> findByCustomerID(long customerID);
}
