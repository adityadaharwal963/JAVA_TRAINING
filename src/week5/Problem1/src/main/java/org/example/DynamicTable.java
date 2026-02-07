package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class DynamicTable {
    Connection conn;
    DynamicTable(Connection connection){
        this.conn =  connection;
    }
    public  void modifyTable(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Table Name:");
        String tableName = sc.nextLine();
        System.out.println("1.Add COLUMN");
        System.out.println("2.Modify COLUMN");
        System.out.println("3.Delete COLUMN");
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                addColumn(tableName);
                break;
                case 2:
                    modifyColumn(tableName);
                    break;
                    case 3:
                        deleteColumn(tableName);
                        break;
                        default:
                            System.out.println("Invalid choice");
        }
    }

    public  void createTable(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Table Name:");
        String tableName = sc.next();
        sc.nextLine();
        System.out.println("Enter 0 when you complete entering column ");
        System.out.println("Enter Column Name: Format [ Name DataType ]");
        ArrayList<String> params = new ArrayList<>();
        while(true){
            String column = sc.nextLine().toLowerCase().trim();
            if(column.equals("0")){
                break;
            }
            params.add(column);
        }

        StringBuilder sql = new StringBuilder("Create Table " + tableName + "(");
        boolean primary_condition = false;
        for(int i=0;i<params.size();i++){
            if(params.get(i).startsWith("id")){
                if(!params.get(i).endsWith("int")){
                    System.out.println("Primary Key ID must be int DataType");
                    break;
                }
                sql.append(params.get(i)).append(" primary key,");
                primary_condition = true;
            }else {
                sql.append(params.get(i)).append(",");
            }
        }
        sql.deleteCharAt(sql.length() - 1).append(");");
        System.out.println(sql.toString());
        if(!primary_condition){
            System.out.println("Primary Condition Not ADDED");
            System.out.println("Table not Created");
            return;
        }

        try(PreparedStatement ps = conn.prepareStatement(sql.toString()) ){
            int rs = ps.executeUpdate();
            System.out.println(rs+" rows affected");
            System.out.println("Table created");
        }catch (SQLException e){
            System.out.println(e.getMessage());
            System.out.println("Table not Created");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void modifyColumn(String Table){
        Scanner sc = new Scanner(System.in);
        Utils.printColumns(Table,conn);
        System.out.println("Enter Column Name:");
        String columnName = sc.next();
        sc.nextLine();
        System.out.println("Enter New DataType:");
        String DataType = sc.next();
        sc.nextLine();
        StringBuilder sql = new StringBuilder("ALTER table "+Table+"  Alter Column " + columnName + "  TYPE "+DataType+";");
        try(PreparedStatement ps = conn.prepareStatement(sql.toString()) ){
            int rs = ps.executeUpdate();
            System.out.println(rs+" rows affected");
            System.out.println(" Alter Column");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    private void addColumn(String Table){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter New Column Name:");
        String columnName = sc.next();
        sc.nextLine();
        System.out.println("Enter New DataType:");
        String DataType = sc.next();
        sc.nextLine();
        StringBuilder sql = new StringBuilder("ALTER table "+Table+"  ADD Column " + columnName + " "+DataType);
        try(PreparedStatement ps = conn.prepareStatement(sql.toString()) ){
            int rs = ps.executeUpdate();
            System.out.println(rs+" rows affected");
            System.out.println(" Alter Column");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    private void deleteColumn(String TableName){
        Scanner sc = new Scanner(System.in);
        Utils.printColumns(TableName,conn);
        System.out.println("Enter Column Name:");
        String columnName = sc.next();
        sc.nextLine();
        StringBuilder sql = new StringBuilder("ALTER table "+TableName+"  DROP Column " + columnName);
        try(PreparedStatement ps = conn.prepareStatement(sql.toString()) ){
            int rs = ps.executeUpdate();
            System.out.println(rs+" rows affected");
            System.out.println(" DROPPED Column");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
