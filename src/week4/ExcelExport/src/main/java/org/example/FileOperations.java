package org.example;

import java.io.*;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileOperations {
    public  boolean exportDB(DBConnection dbConnection, String path) throws FileNotFoundException {
        File file = new File(path+".csv");
        try (FileWriter fw = new FileWriter(file)){
            ArrayList<List<String>> data = dbConnection.viewData();
            for(List<String> row : data){
                try {
                    fw.write(row.get(0)+","+row.get(1)+","+row.get(2)+","+row.get(3)+"\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            };

        }catch (IOException | SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }


    public  boolean importDB(DBConnection dbConnection, String path,String TableName) throws FileNotFoundException {
        File file = new File(path+".csv");
        try (FileReader fr = new FileReader(file)){
            ArrayList<List<String>> data = new ArrayList<>();
            BufferedReader bufferedReader = new BufferedReader(fr);
            String row = bufferedReader.readLine();
            while(row!=null){
                String[] rowData = row.split(",");
                data.add(new ArrayList<>(Arrays.asList(rowData)));
                row = bufferedReader.readLine();
            }
            dbConnection.writeBackupData(TableName,data);
        }catch (IOException | SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("hi");
            return false;
        }
        return true;
    }


}
