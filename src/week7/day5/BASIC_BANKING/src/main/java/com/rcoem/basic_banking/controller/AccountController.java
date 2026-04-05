package com.rcoem.basic_banking.controller;

import com.rcoem.basic_banking.dto.AccountDTO;
import com.rcoem.basic_banking.dto.CreateAccountDTO;
import com.rcoem.basic_banking.dto.TransactionDTO;
import com.rcoem.basic_banking.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/create")
    public AccountDTO createAccount(@RequestBody CreateAccountDTO accountDTO) {
        return accountService.createAccount(accountDTO);
    }


    @PostMapping("/deposit")
    public TransactionDTO deposit(@RequestBody TransactionDTO transactionDTO) {
        return accountService.deposit(transactionDTO);
    }

    @PostMapping("/withdraw")
    public TransactionDTO withdraw(@RequestBody TransactionDTO transactionDTO) {
        return accountService.withdraw(transactionDTO);
    }

    @PostMapping("/transfer")
    public TransactionDTO transfer(@RequestBody TransactionDTO transactionDTO) {
        return accountService.fundTransfer(transactionDTO);
    }

    @GetMapping("/get-transaction")
    public List<TransactionDTO> getTransaction(@RequestBody AccountDTO accountDTO) {
        return accountService.getTransactions(accountDTO);
    }
}
