package com.example.dema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstProjectApplication {

    public static void main(String[] args) {

//        SpringApplication.run(FirstProjectApplication.class, args);
        University u = new RBUUniversity();
        u.welcome();
    }

}
