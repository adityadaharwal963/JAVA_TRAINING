package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            Operation op = new Operation();
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("\n1. Insert | 2. Delete | 3. Delete All | 4. Update | 5. View | 6. Exit");
                System.out.print("Choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                try {
                    switch (choice) {
                        case 1:
                            System.out.print("ID: "); int id = sc.nextInt(); sc.nextLine();
                            System.out.print("Name: "); String n = sc.nextLine();
                            System.out.print("Designation: "); String d = sc.nextLine();
                            System.out.print("Salary: "); int s = sc.nextInt();
                            op.insert(id, n, d, s);
                            break;
                        case 2:
                            System.out.print("ID to delete: ");
                            op.delete(sc.nextInt());
                            break;
                        case 3:
                            op.deleteAll();
                            break;
                        case 4:
                            System.out.print("ID to update: "); int uid = sc.nextInt(); sc.nextLine();
                            System.out.print("Column (name/designation/salary): "); String col = sc.nextLine();
                            System.out.print("New Value: "); String val = sc.nextLine();
                            op.update(col, val, uid);
                            break;
                        case 5:
                            System.out.println("1. All | 2. By Name | 3. By ID");
                            int v = sc.nextInt(); sc.nextLine();
                            if (v == 1) op.view("SELECT * FROM employee", null);
                            else if (v == 2) {
                                System.out.print("Name: ");
                                op.view("SELECT * FROM employee WHERE name = ?", sc.nextLine());
                            } else if (v == 3) {
                                System.out.print("ID: ");
                                op.view("SELECT * FROM employee WHERE eid = ?", sc.nextInt());
                            }
                            break;
                        case 6:
                            System.exit(0);
                    }
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
}
