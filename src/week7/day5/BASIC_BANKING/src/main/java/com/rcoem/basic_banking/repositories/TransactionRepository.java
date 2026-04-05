package com.rcoem.basic_banking.repositories;

import com.rcoem.basic_banking.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
