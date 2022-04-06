package com.db.repositories;

import com.db.models.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Integer> {
    List<Account> findByUserId(int userId);
}
