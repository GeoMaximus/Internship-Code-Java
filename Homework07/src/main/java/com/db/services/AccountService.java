package com.db.services;

import com.db.models.Account;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    //do I really need this service?
    public String generateIBAN(Account account) {
        //come up with a better algorithm for generating the IBAN
        return "001" + account.getCurrency() + account.getId() + "123456789";
    }
}
