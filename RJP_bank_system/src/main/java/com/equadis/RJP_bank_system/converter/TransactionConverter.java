package com.equadis.RJP_bank_system.converter;

import com.equadis.RJP_bank_system.dto.CreateTransactionDTO;
import com.equadis.RJP_bank_system.dto.TransactionDTO;
import com.equadis.RJP_bank_system.entity.Transaction;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

public class TransactionConverter {
    public static TransactionDTO convertTransaction(Transaction transaction) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setId(transaction.getId());
        transactionDTO.setAccountId(transaction.getAccountId());
        transactionDTO.setAmount(transaction.getAmount());
        transactionDTO.setAction(transaction.getAction());
        transactionDTO.setDate(dateFormat.format(transaction.getDate()));
        return transactionDTO;
    }

    public static Transaction convertCreateTransactionDTO(CreateTransactionDTO createTransaction) {
        Date currentDate = new Date();
        Transaction transaction = new Transaction();
        transaction.setAccountId(createTransaction.getAccountId());
        transaction.setAmount(createTransaction.getAmount());
        transaction.setAction(createTransaction.getAction());
        transaction.setDate(currentDate);
        return transaction;
    }
}
