package org.example;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        DBConnection dbc = new DBConnection();
        FileOperations fw = new FileOperations();
        try{
            if(fw.exportDB(dbc,"backup"))
                System.out.println("Successfully exported to backup");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        try {
            fw.importDB(dbc,"backup","employee_backup");
            System.out.println("Successfully imported from backup");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
