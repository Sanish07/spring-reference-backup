package com.sanish.spring_dto_pattern.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "acc_holder_name", length = 50)
    private String account_holder;

    @Column(name = "contact_email", length = 30)
    private String contact_email;

    @OneToOne
    @JoinColumn(name = "emp_id")
    @JsonBackReference
    private Employee employee;

    public Account() {
    }

    public Account(String account_holder, String contact_email) {
        super();
        this.account_holder = account_holder;
        this.contact_email = contact_email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount_holder() {
        return account_holder;
    }

    public void setAccount_holder(String account_holder) {
        this.account_holder = account_holder;
    }

    public String getContact_email() {
        return contact_email;
    }

    public void setContact_email(String contact_email) {
        this.contact_email = contact_email;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", account_holder='" + account_holder + '\'' +
                ", contact_email='" + contact_email + '\'' +
                '}';
    }
}
