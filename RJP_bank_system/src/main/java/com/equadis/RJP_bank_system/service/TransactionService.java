package com.equadis.RJP_bank_system.service;

import com.equadis.RJP_bank_system.dto.CreateTransactionDTO;
import com.equadis.RJP_bank_system.dto.TransactionDTO;
import com.equadis.RJP_bank_system.entity.Transaction;

import java.util.List;

public interface TransactionService {
    public Transaction findTransactionById(long id);

    public TransactionDTO addNewTransaction(CreateTransactionDTO newTransaction);

    public List<TransactionDTO> getAllTransactionsByCustomerId(long customerId);
}
