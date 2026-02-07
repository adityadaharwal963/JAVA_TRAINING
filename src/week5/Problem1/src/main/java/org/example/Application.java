package org.example;

import java.io.FileNotFoundException;
import java.util.Scanner;
// make it work
public class Application {
    public static void run(){
        DBConnection dbConnection = new DBConnection();
        DynamicTable dynamicTable = new DynamicTable(dbConnection.connection);
        System.out.println("Welcome");
        String menu = "Choice:\n" +
                "1. Defines table structure\n" +
                "2. Modify table structure \n" +
                "3. CRUD operations\n" +
                "4. Data imported \n" +
                "5. Data exported";
        System.out.println(menu);
        int  choice;
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            switch (choice){
                case 0:
                    break;
                case 1:
                    dynamicTable.createTable();
                    break;
                case 2:
                    dynamicTable.modifyTable();
                    break;
                case 3:
                    System.out.println("Enter Table Name:");
                    String tableName = sc.next();
                    new CURD(tableName,dbConnection.connection).menu();
                    break;
                case 4:
                    System.out.println("Enter Table Name:");
                    String tableName2 = sc.next();
                    System.out.println("Enter Path:");
                    String Path = sc.next();
                    try {
                        new BackupOperation().importData(Path,tableName2,dbConnection.connection);
                    } catch (FileNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                    case 5:
                        System.out.println("Enter Table Name:");
                        String tableName3 = sc.next();
                        System.out.println("Enter Path:");
                        String path2 = sc.next();
                        try {
                            new BackupOperation().exportData(path2,tableName3, dynamicTable.conn);
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        break;
            }
            System.out.println(menu);
        }
    }
}
