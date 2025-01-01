package com.equadis.RJP_bank_system.entity;

import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "account")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Data
public class Account {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    @Column(name = "customer_id")
    private long customerID;

    @Column(name = "password")
    private String password;

    @Column(name = "balance")
    private double balance;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(long customerID) {
        this.customerID = customerID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
