package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class CURD {
    Connection conn;
    String TableName;
    CURD(String Table, Connection conn){
        this.conn = conn;
        this.TableName = Table;
    }
    void menu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("1.INSERT");
        System.out.println("2.Update");
        System.out.println("3.Read");
        System.out.println("4.Delete");
        System.out.println("Choice:");
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                insert();
                break;
            case 2:
                update();
                break;
            case 3:
                read();
                break;
            case 4:
                delete();
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
    void insert(){
        Scanner sc = new Scanner(System.in);
        ArrayList<String[]> cols = Utils.columns(this.TableName,conn);
        ArrayList<Object> values = new ArrayList();

        for(String[] col:cols){
            if(col[1].toLowerCase().startsWith("int")){
                System.out.println("Enter (int) "+col[0]);
                Integer value = Integer.parseInt(sc.next());
                values.add(value);
            }else {
                System.out.println("Enter "+col[0]);
                String value = sc.next();
                values.add(value);
            }


        }
        StringBuilder sql = new StringBuilder("INSERT INTO "+TableName+" (");
        StringBuilder insertValues = new StringBuilder(" VALUES (");

        for(int i=0;i<cols.size()-1;i++){
            sql.append(cols.get(i)[0]+",");
            insertValues.append("?,");
        }
        sql.append(cols.get(cols.size()-1)[0]+")");
        insertValues.append("?)");

        sql.append(insertValues);

        try(PreparedStatement ps = conn.prepareStatement(sql.toString()) ){
            for(int i=0;i<values.size();i++){

                if(cols.get(i)[1].toLowerCase().startsWith("int")) {
                    ps.setInt(i + 1, (Integer) values.get(i));
                }else {
                    ps.setString(i + 1, (String) values.get(i));
                }
            }

            int rs = ps.executeUpdate();
            System.out.println(rs+" rows affected");
            System.out.println(" Inserted rows");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    void update(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID: ");
        Integer ID = sc.nextInt();
        ArrayList<String[]> cols = Utils.columns(this.TableName,conn);

        Utils.printColumns(TableName, conn);
        System.out.println("Select the column you want to update");
        String column = sc.next();
        sc.nextLine();
        System.out.println("Enter new value:");
        String value = sc.next();
        sc.nextLine();
        String type = "String";
        for(String[] col:cols){
            if(col[0].equals(column)){
                if(col[1].toLowerCase().startsWith("int")){
                    type = "Integer";
                }
                break;
            }
        }
        String sql = "UPDATE "+TableName+" SET "+column+"=? WHERE ID=?";

        try(PreparedStatement ps = conn.prepareStatement(sql) ){
            if(type=="String"){
                ps.setString(1,value);
            }else {
                ps.setInt(1, Integer.parseInt(value));
            }
            ps.setString(1, value);
            ps.setInt(2, ID);
            int rs = ps.executeUpdate();
            System.out.println(rs+" rows affected");
            System.out.println(" Deleted rows");
        }catch (SQLException e){
            System.out.println(e.getMessage());
            System.out.println("Table not Created");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    void delete(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID:");
        Integer ID = sc.nextInt();

        String sql = "Delete from "+TableName+" where ID=?";

        try(PreparedStatement ps = conn.prepareStatement(sql) ){
            ps.setInt(1, ID);
            int rs = ps.executeUpdate();
            System.out.println(rs+" rows affected");
            System.out.println(" Deleted rows");
        }catch (SQLException e){
            System.out.println(e.getMessage());
            System.out.println("Table not Created");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    void read(){
        ArrayList<String[]> columns = Utils.columns(this.TableName,conn);
        // print headers
        Utils.printColumns(TableName,conn);
        System.out.println();
        String sql = "select * from "+TableName;
        try(PreparedStatement ps = conn.prepareStatement(sql) ){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                for(int i=0;i<columns.size();i++){
                    System.out.print(rs.getObject(columns.get(i)[0]).toString()+"|");
                }
                System.out.println();
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
            System.out.println("Table not Created");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


}
