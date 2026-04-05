package com.rcoem.basic_banking.dto;

public class CreateAccountDTO {
    private Long customerId;
    private String type;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
