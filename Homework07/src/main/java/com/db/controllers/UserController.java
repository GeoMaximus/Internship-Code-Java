package com.db.controllers;

import com.db.exceptions.UserException;
import com.db.models.Account;
import com.db.models.User;
import com.db.repositories.AccountRepository;
import com.db.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerError;
import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    AccountRepository accountRepository;

    @GetMapping("/users")
    public User getUsersById(int id) {
        User user = userRepository.findById(id).get();
        return user;
    }

    @GetMapping("/search")
    public List<User> searchUserByFirstName(@RequestParam String firstName) {
        //test to see if it work properly
        return userRepository.findByFirstName(firstName);
    }

    @PostMapping("/user/create")
    public ResponseEntity<Account> createAccount(@RequestBody Account newAccount) throws UserException {
        //add smth if user doesnt exist
        //add smth to add to an existing user
        Account account = accountRepository.save(newAccount);
        if(account == null) {
            throw new UserException("The user you are trying to create is null");
        } else {
            return new ResponseEntity<>(account, HttpStatus.CREATED);
        }
    }

    @GetMapping("/user/accounts")
    public List<Account> getAccountsByUserId(int userId) {
        List<Account> accounts = new ArrayList<>();
        for (Account account : accountRepository.findByUserId(userId)) {
            accounts.add(account);
        }
        return accounts;
    }
}
