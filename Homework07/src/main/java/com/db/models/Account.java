package com.db.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "user_id")
    private int userId;
    private Currency currency;
    private String IBAN;

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }
}
