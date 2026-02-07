package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    Connection connection;
    DBConnection() {
        String jdbcURL = "jdbc:postgresql://localhost:5436/mydatabase";
        String username = "myuser";
        String password = "mypassword";
        //load driver
        try{
            Class.forName("org.postgresql.Driver");
                this.connection
                        = DriverManager.getConnection(
                        jdbcURL, username, password);
                System.out.println("Connected to database successfully");
            }catch(Exception e){
                e.printStackTrace();
            }
    }
}
