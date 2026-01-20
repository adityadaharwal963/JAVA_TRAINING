package IO;

import java.io.*;
import java.util.ArrayList;

public class Problem5 {
    /*
    Problem Statement: Write a program that:
    Reads employee data (name, id, salary) from a CSV file (employees.csv) using
    BufferedReader.
    Creates Employee objects for each record and adds them to a list.
    Serializes the list of Employee objects to a file (employees.ser).
    Deserializes the list back and prints all employee details to the console.
    Requirements:
    ● Use BufferedReader for reading the CSV file.
    ● Implement Serializable in the Employee class.
     */

    static void readEmployeeCsv(){
        ArrayList<Employee> employees = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader("IO/employees.csv"))){
            try {

                String data = reader.readLine();
                while (data!=null) {
                    String[] row = data.trim().split(",");
                    employees.add(new Employee(row[0], Integer.parseInt(row[1])));
                    data = reader.readLine();
                }
            }catch (EOFException e){
                System.out.println("Data read completely");
            }
        }catch ( IOException e){
            System.out.println(e.getMessage());
        }
        for (Employee emp : employees){
            System.out.println(emp);
        }
    }
    public static void main(String[] args) {
        readEmployeeCsv();
    }
}

class  Employee{
    private String name;
    private int salary;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }


}