package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Utils {
    static ArrayList<String[]> columns(String tableName, Connection conn) {
        ArrayList<String[]> columns = new ArrayList<>();
        String columnSql = "SELECT COLUMN_NAME,DATA_TYPE FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = ? ;";

        try(PreparedStatement ps = conn.prepareStatement(columnSql) ){
            ps.setString(1, tableName);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                columns.add(new String[]{rs.getString("COLUMN_NAME"), rs.getString("DATA_TYPE")});
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return columns;
    }
    static void printColumns(String tableName, Connection conn) {
        ArrayList<String[]> columns = columns(tableName, conn);
        System.out.println("Columns:");
        for(String[] column : columns){
            System.out.print(column[0]+"|");
        }
        System.out.println();
    }
}
