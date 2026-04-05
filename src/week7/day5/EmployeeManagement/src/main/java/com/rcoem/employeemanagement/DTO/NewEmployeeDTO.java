package com.rcoem.employeemanagement.DTO;

import java.util.Set;

public class NewEmployeeDTO {

    private String username;
    private String password;
    private String name;
    private String role;
    private Set<String> permissions;
    private Long senior_id;

    public Long getSenior_id() {
        return senior_id;
    }

    public void setSenior_id(Long senior_id) {
        this.senior_id = senior_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<String> permissions) {
        this.permissions = permissions;
    }
}
