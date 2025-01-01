package com.equadis.RJP_bank_system.controller;

import com.equadis.RJP_bank_system.dto.CustomerDTO;
import com.equadis.RJP_bank_system.entity.Customer;
import com.equadis.RJP_bank_system.service.CustomerService;
import com.equadis.RJP_bank_system.vo.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    public CustomerService customerService;

    @GetMapping(value = "/customer/{email}")
    public ResponseBean<Customer> getAllCustomer(
            @PathVariable String email
    ) {
        try {
            return ResponseBean.success(customerService.getCustomerByEmail(email));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBean.error(e.getMessage());
        }
    }

    @PostMapping(value = "/customer/create")
    public ResponseBean<Customer> createCustomer(
            @RequestBody CustomerDTO customerDTO
    ) {
        try {
            return ResponseBean.success(customerService.addNewCustomer(customerDTO));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBean.error(e.getMessage());
        }
    }
}
