package com.rcoem.project2;

import java.util.Scanner;

public class Test_Login {

    public static void main(String[] args) {
        Login login = new Login();
        login.setUserName("admin");
        login.setPassword("123456");
        int chance = 3;
        Scanner sc = new Scanner(System.in);
        while (chance-- > 0) {

            System.out.println("Enter Username:");
            String username = sc.next();
            System.out.println("Enter Password:");
            String password = sc.next();
            if (login.login(username, password)) {
                System.out.println("Login Successful");
                return;
            }else {
                System.out.println("Login Failed");
            }
        }
        System.out.println("Goodbye, Limit exceeded");
        return;
    }
}
