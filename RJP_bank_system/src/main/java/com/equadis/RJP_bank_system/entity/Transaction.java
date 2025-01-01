package com.equadis.RJP_bank_system.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "transaction")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Transaction {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    @Column(name = "account_id")
    private long accountId;

    @Column(name = "amount")
    private double amount;

    @Column(name = "action")
    private String action /* deposit | withdrawal */;

    @Column(name = "date")
    private Date date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
