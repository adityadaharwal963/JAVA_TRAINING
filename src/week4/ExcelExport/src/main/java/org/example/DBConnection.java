package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {
    public Connection connection;
    public DBConnection(){
        String jdbcURL = "jdbc:postgresql://localhost:5436/mydatabase";
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

    public ArrayList<List<String>> viewData() throws SQLException {
        ArrayList<List<String>> list = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement("Select * FROM employee;");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()){
            List<String> employee = new ArrayList<>();
            employee.add(rs.getString(1));
            employee.add(rs.getString(2));
            employee.add(rs.getString(3));
            Integer salary = rs.getInt(4);
            employee.add(salary.toString());
            list.add(employee);
        }
        return list;
    }

    public boolean writeBackupData(String newTableName,ArrayList<List<String>> data) throws SQLException {
        System.out.println(newTableName);
        System.out.println(data.size());
        // create table
        Statement createStatement = connection.createStatement();
        String sql ="Create table if not exists " + newTableName+"("+
                "eid  VARCHAR(20),"+
                "name VARCHAR(20),"+
                "designation VARCHAR(20),"+
                "salary INT"+
                ");";
        createStatement.executeUpdate(sql);

        for(List<String> rowData : data){
            PreparedStatement preparedSt = connection.prepareStatement("INSERT INTO "+newTableName+" Values (?,?,?,?);");
            preparedSt.setString(1, rowData.get(0));
            preparedSt.setString(2, rowData.get(1));
            preparedSt.setString(3, rowData.get(2));
            preparedSt.setInt(4, Integer.parseInt(rowData.get(3)));
            preparedSt.executeUpdate();
        }
        return true;
    }
}

