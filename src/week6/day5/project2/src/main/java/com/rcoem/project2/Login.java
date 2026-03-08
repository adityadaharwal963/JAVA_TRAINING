package com.rcoem.project2;

public class Login {

    String userName;
    String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean login(String username, String password) {
        if (userName.equals(username) && password.equals(password)) {
            return true;
        }
        return false;
    }
}
