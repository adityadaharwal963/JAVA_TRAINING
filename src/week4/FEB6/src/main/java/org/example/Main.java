package org.example;

import java.sql.PreparedStatement;

public class Main {
    public static void main(String[] args) {

    }

    void func(){
        DBConnection dbConnection = new org.example.DBConnection();
        try{
            PreparedStatement preparedStatement = dbConnection.connection.prepareStatement("" +
                    "CREATE TABLE ");
        }catch( e){

        }
    }
}
