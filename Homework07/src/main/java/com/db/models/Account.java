package com.db.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "accounts")
public class Account {
    @Id
    private int id;
    @Column(name = "user_id")
    private int userId;
    private int IBAN;
}
