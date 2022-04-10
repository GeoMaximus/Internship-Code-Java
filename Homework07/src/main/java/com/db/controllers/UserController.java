package com.db.controllers;

import com.db.exceptions.InvalidUserException;
import com.db.models.User;
import com.db.repositories.AccountRepository;
import com.db.repositories.UserRepository;
import com.db.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountService accountService;

    @PostMapping("create")
    public void createUser(@RequestBody User user) {
        userRepository.save(user);
    }

    @GetMapping("/{id}")
    public User getUsersById(@PathVariable int id) throws InvalidUserException {
            return userRepository.findById(id)
                    .orElseThrow(() -> new InvalidUserException("The user does not exist!"));
    }

    @GetMapping("/search")
    public List<User> searchUserByFirstName(@RequestParam String firstName) {
        return userRepository.findByFirstName(firstName);
    }
}
