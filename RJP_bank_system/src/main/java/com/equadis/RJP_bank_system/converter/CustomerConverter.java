package com.equadis.RJP_bank_system.converter;

import com.equadis.RJP_bank_system.dto.CustomerDTO;
import com.equadis.RJP_bank_system.entity.Customer;

public class CustomerConverter {
    public static Customer convertCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        return customer;
    }
}
