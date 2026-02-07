package org.example;

import java.sql.*;

public class DBConnection {
    public Connection connection;
    public DBConnection(){
        String jdbcURL = "jdbc:postgresql://localhost:5436/test";
        String username = "myuser";
        String password = "mypassword";
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

