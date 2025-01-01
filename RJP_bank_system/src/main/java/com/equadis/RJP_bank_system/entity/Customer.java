package com.equadis.RJP_bank_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name= "customer")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name= "email")
    private String email;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
