package com.equadis.RJP_bank_system.service.impl;

import com.equadis.RJP_bank_system.converter.TransactionConverter;
import com.equadis.RJP_bank_system.dao.AccountMapper;
import com.equadis.RJP_bank_system.dao.TransactionMapper;
import com.equadis.RJP_bank_system.dto.CreateTransactionDTO;
import com.equadis.RJP_bank_system.dto.TransactionDTO;
import com.equadis.RJP_bank_system.entity.Account;
import com.equadis.RJP_bank_system.entity.Transaction;
import com.equadis.RJP_bank_system.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionMapper transactionMapper;

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Transaction findTransactionById(long id) {
        Transaction transaction = transactionMapper.findById(id).orElseThrow(() -> new IllegalStateException("Transaction does not exist"));
        return transaction;
    }

    @Override
    public TransactionDTO addNewTransaction(CreateTransactionDTO NewTransaction) {
        Account account = accountMapper.findById(NewTransaction.getAccountId()).orElseThrow(() -> new IllegalStateException("Account does not exist"));
        if (NewTransaction.getAmount() == 0) {
            throw new IllegalStateException("Meaningless transaction!");
        } else {
            if (NewTransaction.getAction().equals("deposit")) {
                account.setBalance(account.getBalance() + NewTransaction.getAmount());
                Transaction transaction = transactionMapper.save(TransactionConverter.convertCreateTransactionDTO(NewTransaction));
                return TransactionConverter.convertTransaction(transaction);
            } else if (NewTransaction.getAction().equals("withdrawal")) {
                if (account.getBalance() < NewTransaction.getAmount()) {
                    throw new IllegalStateException("You have not enough money to withdraw this transaction");
                } else {
                    account.setBalance(account.getBalance() - NewTransaction.getAmount());
                    Transaction transaction = transactionMapper.save(TransactionConverter.convertCreateTransactionDTO(NewTransaction));
                    return TransactionConverter.convertTransaction(transaction);
                }
            } else {
                throw new IllegalStateException("Irregular operation, please try again.");
            }
        }
    }

    @Override
    public List<TransactionDTO> getAllTransactionsByCustomerId(long accountId) {
        List<Transaction> transactionList = transactionMapper.findByAccountId(accountId);

        List<TransactionDTO> transactionDTOList = new ArrayList<TransactionDTO>();
        for (Transaction transaction : transactionList) {
            transactionDTOList.add(TransactionConverter.convertTransaction(transaction));
        }

        return transactionDTOList;
    }
}
