package com.db.services;

import com.db.models.Account;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    //do I really need this service?
    public String generateIBAN(Account account) {
        return "001" + account.getCurrency() + account.getId()/4 + "123456789";
    }
}
