package com.db.controllers;

import com.db.exceptions.NullAccountException;
import com.db.exceptions.NullUserException;
import com.db.models.Account;
import com.db.models.User;
import com.db.repositories.AccountRepository;
import com.db.repositories.UserRepository;
import com.db.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public User getUsersById(@PathVariable int id) throws NullUserException {
        //add an exception if the user does not exist
        if (!userRepository.existsById(id)) {
            throw new NullUserException("The user does not exist");
        } else {
            return userRepository.findById(id).get();
        }
    }

    @GetMapping("/users/search")
    public List<User> searchUserByFirstName(@RequestParam String firstName) {
        //test to see if it works properly
        //user should be able to search with partial name
        return userRepository.findByFirstName(firstName);
    }

    @PostMapping("/accounts/create")
    public ResponseEntity<Account> createAccount(@RequestBody Account newAccount) throws NullUserException, NullAccountException {
        //add exception if user doesn't exist
        //add exception if account already exists
        newAccount.setIBAN(accountService.generateIBAN(newAccount));
        accountRepository.save(newAccount);
        if (newAccount == null) {
            throw new NullAccountException("The account you are trying to create is null");
        }
        if (accountRepository.existsById(newAccount.getId())) {
            throw new NullAccountException("The account already exists");
        }
        if (!userRepository.existsById(newAccount.getUserId())) {
            throw new NullUserException("The user does not exist");
        } else {
            return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
        }
    }

    @GetMapping("/user/accounts/{userId}")
    public List<Account> getAccountsByUserId(@PathVariable int userId) throws NullUserException {
        //treat exception if the userId does not exist
        if (!userRepository.existsById(userId)) {
            throw new NullUserException("The user does not exist");
        } else {
            return new ArrayList<>(accountRepository.findByUserId(userId));
        }
    }
}
