package com.equadis.RJP_bank_system.converter;

import com.equadis.RJP_bank_system.dto.AccountDTO;
import com.equadis.RJP_bank_system.dto.CreateAccountDTO;
import com.equadis.RJP_bank_system.entity.Account;

public class AccountConverter {
    public static AccountDTO convertAccount(Account account) {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(account.getId());
        accountDTO.setCustomerID(account.getCustomerID());
        accountDTO.setBalance(account.getBalance());
        return accountDTO;
    }

    public static Account convertCreateAccountDTO(long customerId, CreateAccountDTO createAccountDTO) {
        Account account = new Account();
        account.setCustomerID(customerId);
        account.setPassword(createAccountDTO.getPassword());
        account.setBalance(createAccountDTO.getBalance());
        return account;
    }
}
