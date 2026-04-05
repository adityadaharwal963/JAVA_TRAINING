package com.rcoem.basic_banking.services;

import com.rcoem.basic_banking.dto.AccountDTO;
import com.rcoem.basic_banking.dto.CreateAccountDTO;
import com.rcoem.basic_banking.dto.TransactionDTO;
import com.rcoem.basic_banking.entities.Account;
import com.rcoem.basic_banking.entities.Customer;
import com.rcoem.basic_banking.entities.Transaction;
import com.rcoem.basic_banking.exception.AccountNotFoundException;
import com.rcoem.basic_banking.exception.CustomerNotFoundException;
import com.rcoem.basic_banking.exception.InsufficientBalanceException;
import com.rcoem.basic_banking.repositories.AccountRepository;
import com.rcoem.basic_banking.repositories.CustomerRepository;
import com.rcoem.basic_banking.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    TransactionRepository transactionRepository;

    public AccountDTO createAccount(CreateAccountDTO accountDTO)
    {
        Account account = new Account();
        Customer customer = customerRepository.findById(accountDTO.getCustomerId()).orElse(null);
        if (customer == null) {
            throw new CustomerNotFoundException("Customer not found");
        }
        account.setCustomer(customer);
        account.setBalance(0.0);
        account.setType(accountDTO.getType());
        account = accountRepository.save(account);

        AccountDTO accountDTO2 = new AccountDTO();
        accountDTO2.setAccountId(account.getId());
        accountDTO2.setBalance(account.getBalance());
        return accountDTO2;
    }

    public TransactionDTO deposit(TransactionDTO transactionDTO)
    {
        // receiver id must not be null
        Account account = accountRepository.findById(transactionDTO.getRecipient()).orElse(null);
        if (account == null) {
            throw new AccountNotFoundException("Account not found");
        }

        account.setBalance(account.getBalance() + transactionDTO.getAmount());
        Transaction transaction = new Transaction();
        transaction.setAmount(transactionDTO.getAmount());
        transaction.setType("deposit");
        transaction.setRecipient(account);
        transactionRepository.save(transaction);
        transactionDTO.setType(transaction.getType());
        transactionDTO.setAmount(transaction.getAmount());
        return transactionDTO;
    }

    public TransactionDTO withdraw(TransactionDTO transactionDTO){
        // sender id must not be null
        Account account = accountRepository.findById(transactionDTO.getSender()).orElse(null);
        if (account == null) {
            throw new AccountNotFoundException("Account not found");
        }

        if (account.getBalance() < transactionDTO.getAmount()) {
            throw new InsufficientBalanceException("Insufficient balance");
        }

        account.setBalance(account.getBalance() - transactionDTO.getAmount());
        Transaction transaction = new Transaction();
        transaction.setAmount(transactionDTO.getAmount());
        transaction.setType("withdraw");
        transaction.setRecipient(account);
        transactionRepository.save(transaction);
        transactionDTO.setType(transaction.getType());
        transactionDTO.setAmount(transaction.getAmount());
        return transactionDTO;

    }

    public TransactionDTO fundTransfer(TransactionDTO transactionDTO){
         Account sender = accountRepository.findById(transactionDTO.getSender()).orElse(null);
         Account receiver = accountRepository.findById(transactionDTO.getRecipient()).orElse(null);
         if (sender == null) {
            throw new AccountNotFoundException("Sender not found");
         }
         if (receiver == null) {
             throw new AccountNotFoundException("Receiver not found");
         }

         if (sender.getBalance() < transactionDTO.getAmount()) {
             throw new InsufficientBalanceException("Insufficient balance");
         }

         sender.setBalance(sender.getBalance() - transactionDTO.getAmount());
         receiver.setBalance(receiver.getBalance() + transactionDTO.getAmount());
         Transaction transaction = new Transaction();
         transaction.setAmount(transactionDTO.getAmount());
         transaction.setType("transfer");
         transaction.setRecipient(sender);
         transaction.setRecipient(receiver);
         transactionRepository.save(transaction);

         transactionDTO.setType(transaction.getType());
         transactionDTO.setAmount(transaction.getAmount());
         return transactionDTO;
    }

    public List<TransactionDTO> getTransactions(AccountDTO accountDTO){
        Account account = accountRepository.findById(accountDTO.getAccountId()).orElse(null);
        if (account == null) {
            throw new AccountNotFoundException("Account not found");
        }

        List<TransactionDTO> transactions = new ArrayList<>();
        for(Transaction transaction : account.getTransactions()){
            TransactionDTO transactionDTO = new TransactionDTO();
            transactionDTO.setAmount(transaction.getAmount());
            transactionDTO.setSender(transaction.getSender().getId());
            transactionDTO.setRecipient(transaction.getRecipient().getId());
            transactionDTO.setType(transaction.getType());
            transactions.add(transactionDTO);
        }
        return transactions;
    }

}
