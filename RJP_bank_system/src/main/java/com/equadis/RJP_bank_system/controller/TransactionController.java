package com.equadis.RJP_bank_system.controller;

import com.equadis.RJP_bank_system.dto.CreateTransactionDTO;
import com.equadis.RJP_bank_system.dto.TransactionDTO;
import com.equadis.RJP_bank_system.entity.Transaction;
import com.equadis.RJP_bank_system.service.TransactionService;
import com.equadis.RJP_bank_system.vo.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {
    @Autowired
    public TransactionService transactionService;

    @GetMapping(value = "/trans/{id}")
    public ResponseBean<Transaction> getTransaction(@PathVariable long id) {
        try {
            return ResponseBean.success(transactionService.findTransactionById(id));
        } catch (Exception e) {
            return ResponseBean.error(e.getMessage());
        }
    }

    @PostMapping(value = "/trans/create")
    public ResponseBean<TransactionDTO> createTransaction(@RequestBody CreateTransactionDTO newTransaction) {
        try {
            return ResponseBean.success(transactionService.addNewTransaction(newTransaction));
        } catch (Exception e) {
            return ResponseBean.error(e.getMessage());
        }
    }

    @GetMapping(value = "/trans/all")
    public ResponseBean<List<TransactionDTO>> getAllTransactionsByCustomerId(@RequestParam long customerId) {
        try {
            return ResponseBean.success(transactionService.getAllTransactionsByCustomerId(customerId));
        } catch (Exception e) {
            return ResponseBean.error(e.getMessage());
        }
    }
}
