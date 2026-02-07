package org.example;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FileOperations {
    FileOperations(){}
    public  boolean export(DBConnection dbConnection, String path) throws FileNotFoundException {
        File file = new File(path+".csv");
        try (FileWriter fw = new FileWriter(file)){
            ArrayList<List<String>> data = dbConnection.viewData();
            data.stream().forEach(row -> {
                try {
                    fw.write(row.get(0)+","+row.get(1)+","+row.get(2)+","+row.get(3)+"\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

        }catch (IOException | SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
