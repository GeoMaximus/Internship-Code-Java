package com.db.controllers;

import com.db.exceptions.UserException;
import com.db.models.Account;
import com.db.models.User;
import com.db.repositories.AccountRepository;
import com.db.repositories.UserRepository;
import com.db.services.AccountService;
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

    @Autowired
    AccountService accountService;

    @PostMapping("/users/create")
    public void createUser(@RequestBody User user) {
        userRepository.save(user);
    }

    @GetMapping("/users/{id}")
    public User getUsersById(@PathVariable int id) {
        User user = userRepository.findById(id).get();
        return user;
    }

    @GetMapping("/users/search")
    public List<User> searchUserByFirstName(@RequestParam String firstName) {
        //test to see if it works properly
        return userRepository.findByFirstName(firstName);
    }

    @PostMapping("/accounts/create")
    public ResponseEntity<Account> createAccount(@RequestBody Account newAccount) throws UserException {
        //add smth if user doesnt exist
        //add smth to add to an existing user
        newAccount.setIBAN(accountService.generateIBAN(newAccount));
        accountRepository.save(newAccount);
        if(newAccount == null) {
            throw new UserException("The account you are trying to create is null");
        } else {
            return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
        }
    }

    @GetMapping("/user/accounts/{userId}")
    public List<Account> getAccountsByUserId(@PathVariable int userId) {
        return new ArrayList<>(accountRepository.findByUserId(userId));
    }
}
