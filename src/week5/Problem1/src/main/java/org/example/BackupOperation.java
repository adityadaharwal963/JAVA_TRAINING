package org.example;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class BackupOperation {
    void importData(String path,String newTableName,Connection conn) throws FileNotFoundException {

        File file = new File(path);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        try {
            ArrayList<String[]> column = new ArrayList<>();
            // read headers
            String header = br.readLine();

            String dataType= br.readLine();
            if(header==null || dataType==null){
                System.out.println("Invalid File");
                return;
            }

            String[] head = header.split(",");
            String[] type = dataType.split(",");

            for(int i=0;i<head.length;i++){
                column.add(new String[]{head[i],type[i]});
            }

            // create table
            StringBuilder sql = new StringBuilder("Create Table " + newTableName + "(");
            for(int i=0;i<column.size();i++){
                    String typ = column.get(i)[1];
                    sql.append(column.get(i)[0]);
                    if(typ.equals("Integer")){

                        sql.append(" int");
                        if(column.get(i)[0].toLowerCase().equals("id")){
                            sql.append(" primary key ");
                        }
                        sql.append(",");
                    }else {
                        sql.append(" varchar(50),");
                    }
            }
            sql.deleteCharAt(sql.length() - 1).append(");");


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

            String line = br.readLine();

            // read data
            while (line != null) {
                String[] values = line.split(",");
                insert(column,values,newTableName,conn);
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error reading file");
            System.out.println(e.getMessage());
        }

    }
    void exportData(String path, String table, Connection conn) throws FileNotFoundException {

        File file = new File(path);
        try {
            FileWriter fileWriter = new FileWriter(file);
            ArrayList<String[]> columns = Utils.columns(table,conn );
            // write header
            for(int i=0;i<columns.size()-1;i++){
                fileWriter.write(columns.get(i)[0]+',');
            }
            fileWriter.write(columns.get(columns.size()-1)[0]+'\n');
            // write data type
            for(int i=0;i<columns.size()-1;i++){
                fileWriter.write(columns.get(i)[1]+',');
            }
            fileWriter.write(columns.get(columns.size()-1)[1]+'\n');

            String sql = "select * from "+table;
            try(PreparedStatement ps = conn.prepareStatement(sql) ){
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    for(int i=0;i<columns.size()-1;i++){
                        fileWriter.write(rs.getObject(columns.get(i)[0]).toString()+",");
                    }
                    fileWriter.write(rs.getObject(columns.get(columns.size()-1)[0]).toString()+"\n");
                }
                fileWriter.flush();
                fileWriter.close();
            }catch (SQLException e){
                System.out.println(e.getMessage());
                System.out.println("File not Created");
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        } catch (IOException e) {
            System.out.println("Error writing file");
            System.out.println(e.getMessage());
        }

    }


    void insert(ArrayList<String[]> cols,String[] values,String TableName,Connection conn){


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
            for(int i=0;i<values.length;i++){

                if(cols.get(i)[1].toLowerCase().startsWith("int")) {
                    ps.setInt(i + 1, Integer.parseInt(values[i]));
                }else {
                    ps.setString(i + 1, (String) values[i]);
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
}
