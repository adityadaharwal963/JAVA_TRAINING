package com.rcoem.basic_banking.repositories;

import com.rcoem.basic_banking.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
