package com.equadis.RJP_bank_system.service.impl;

import com.equadis.RJP_bank_system.converter.CustomerConverter;
import com.equadis.RJP_bank_system.dao.CustomerMapper;
import com.equadis.RJP_bank_system.dto.CustomerDTO;
import com.equadis.RJP_bank_system.entity.Customer;
import com.equadis.RJP_bank_system.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerMapper customerMapper;

    @Override
    public Customer getCustomerByEmail(String email) {
        Customer customer = customerMapper.findByEmail(email);
        if (customer == null) {
           throw new IllegalStateException("Customer not found");
        }
        return customer;
    }

    @Override
    public Customer addNewCustomer(CustomerDTO customerDTO) {
        Customer check = customerMapper.findByEmail(customerDTO.getEmail());
        if (check != null) {
            throw new IllegalStateException("Customer already exists");
        }
        Customer customer = customerMapper.save(CustomerConverter.convertCustomer(customerDTO));
        return customer;
    }

}
