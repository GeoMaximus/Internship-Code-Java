package com.db.services;

import com.db.models.Account;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    public String generateIBAN(Account account) {
        String IBAN = "001" + account.getCurrency() + account.getId() + "123456789";
        return IBAN;
    }
}
