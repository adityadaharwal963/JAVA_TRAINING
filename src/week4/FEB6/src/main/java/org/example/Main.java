package org.example;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        func();
    }


    static void func() throws SQLException {
        DBConnection dbConnection = new org.example.DBConnection();
        try{
            Scanner scanner = new Scanner(System.in);
            String tableName = scanner.next();
            scanner.nextLine();

            HashMap<String, String> params = new HashMap<>();
            System.out.println("Enter Params and Type : Format 'Name,TYPE' , 0 to exit:");
            while (true){
                String line = scanner.nextLine();
                if (line.equals("0"))
                    break;
                String[] param = line.split(",");
                params.put(param[0], param[1]);
            }
            StringBuilder sb = new StringBuilder();
            params.forEach((k,v)->{ sb.append(" ").append(k).append(" ").append(v).append(",");});
            sb.deleteCharAt(sb.length()-1);
            PreparedStatement preparedStatement = dbConnection.connection.prepareStatement("" +
                    "Create table if not exists "+ tableName+"("+
                    sb.toString() +
                    ");");

            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Table not created");
        }
    }
}
