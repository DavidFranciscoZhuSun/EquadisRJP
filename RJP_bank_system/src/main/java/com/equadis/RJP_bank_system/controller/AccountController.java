package com.equadis.RJP_bank_system.controller;

import com.equadis.RJP_bank_system.dto.AccountDTO;
import com.equadis.RJP_bank_system.dto.CreateAccountDTO;
import com.equadis.RJP_bank_system.vo.ResponseBean;
import com.equadis.RJP_bank_system.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {
    @Autowired
    public AccountService accountService;

    @GetMapping(value = "/account/{id}")
    public ResponseBean<AccountDTO> getAccountById(
            @PathVariable long id
    ) {
        try {
            return ResponseBean.success(accountService.getAccountByID(id));
        } catch (Exception e) {
            return ResponseBean.error(e.getMessage());
        }
    }

    @PostMapping(value = "/account/create")
    public ResponseBean<AccountDTO> createAccount(
        @RequestBody CreateAccountDTO createAccountDTO
    ) {
        try {
            return ResponseBean.success(accountService.addNewAccount(createAccountDTO));
        } catch (Exception e) {
            return ResponseBean.error(e.getMessage());
        }
    }
}
