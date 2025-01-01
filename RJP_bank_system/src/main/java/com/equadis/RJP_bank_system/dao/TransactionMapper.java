package com.equadis.RJP_bank_system.dao;

import com.equadis.RJP_bank_system.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionMapper extends JpaRepository<Transaction, Long> {
    List<Transaction> findByAccountId(Long accountId);
}
