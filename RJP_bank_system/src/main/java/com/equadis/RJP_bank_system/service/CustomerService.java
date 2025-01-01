package com.equadis.RJP_bank_system.service;

import com.equadis.RJP_bank_system.dto.AccountDTO;
import com.equadis.RJP_bank_system.dto.CustomerDTO;
import com.equadis.RJP_bank_system.entity.Customer;

import java.util.List;

public interface CustomerService {

    public Customer getCustomerByEmail(String email);

    public Customer addNewCustomer(CustomerDTO customerDTO);
}
