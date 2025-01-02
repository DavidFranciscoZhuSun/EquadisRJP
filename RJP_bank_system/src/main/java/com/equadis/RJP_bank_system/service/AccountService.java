package com.equadis.RJP_bank_system.service;

import com.equadis.RJP_bank_system.dto.AccountDTO;
import com.equadis.RJP_bank_system.dto.CreateAccountDTO;

public interface AccountService {

    public AccountDTO getAccountByID(long id);

    public AccountDTO addNewAccount(CreateAccountDTO createAccountDTO);

    public Boolean checkAccount(long id, String password);

}
