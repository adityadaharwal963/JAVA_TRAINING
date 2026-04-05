package com.rcoem.basic_banking.dto;

import com.rcoem.basic_banking.entities.Account;

import java.util.ArrayList;
import java.util.List;

public class CustomerDTO {
    private Long customerId;
    private String name;
    private String email;
    private String phone;
    private String address;
    private List<AccountDTO> accounts;

    public List<AccountDTO> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = new ArrayList<>();
        for (Account account : accounts) {
            AccountDTO accountDTO = new AccountDTO();
            accountDTO.setAccountId(account.getId());
            accountDTO.setBalance(account.getBalance());
            this.accounts.add(accountDTO);
        }
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
