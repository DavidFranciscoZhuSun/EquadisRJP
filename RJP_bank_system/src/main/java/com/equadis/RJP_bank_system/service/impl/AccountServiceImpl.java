package com.equadis.RJP_bank_system.service.impl;

import com.equadis.RJP_bank_system.converter.AccountConverter;
import com.equadis.RJP_bank_system.dao.AccountMapper;
import com.equadis.RJP_bank_system.dao.CustomerMapper;
import com.equadis.RJP_bank_system.dto.AccountDTO;
import com.equadis.RJP_bank_system.dto.CreateAccountDTO;
import com.equadis.RJP_bank_system.entity.Account;
import com.equadis.RJP_bank_system.entity.Customer;
import com.equadis.RJP_bank_system.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public AccountDTO getAccountByID(long id) {
        Account account = accountMapper.findById(id).orElseThrow(() -> new IllegalStateException("Account does not exist"));
        return AccountConverter.convertAccount(account);
    }

    @Override
    public AccountDTO addNewAccount(CreateAccountDTO createAccountDTO) {
        Customer customer = customerMapper.findByEmail(createAccountDTO.getEmail());
        if (customer == null) {
            throw new IllegalStateException("Customer email: " + createAccountDTO.getEmail() + " does not exist.");
        }
        List<Account> AccountList = accountMapper.findByCustomerID(customer.getId());
        if (!CollectionUtils.isEmpty(AccountList)) {
            throw new IllegalStateException("Customer: " + createAccountDTO.getEmail() + " already have an account.");
        }

        Account account = accountMapper.save(AccountConverter.convertCreateAccountDTO(customer.getId(), createAccountDTO));

        return AccountConverter.convertAccount(account);
    }
}
