package com.equadis.RJP_bank_system.dao;

import com.equadis.RJP_bank_system.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerMapper extends JpaRepository<Customer, Long> {
    Customer findByEmail(String email);
}
