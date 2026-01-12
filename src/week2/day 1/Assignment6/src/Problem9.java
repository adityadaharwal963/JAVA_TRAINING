import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Problem9 {
    /*
    9. Nested Exceptions
    Write a program where one exception causes another exception. For instance:
        ● Try to access a file that doesn’t exist (causing a FileNotFoundException).
        ● Within the catch block, attempt to divide by zero (causing an
        ArithmeticException). Use nested try-catch blocks to handle both
        exceptions.
     */
    public static  void readFile(String filePath){
        try{
            // declare file reader with file path
            FileReader reader = new FileReader(filePath);
            //read content
            String line = String.valueOf(reader.read());
            //display content
            System.out.println(line);


        }catch (FileNotFoundException e){
            System.out.println("Enter a valid File Path");
            try{
                int y = 5/0;// attempt to divide by zero
            }catch (ArithmeticException ex){
                System.out.println("Arithmetic Exception: "+ ex.getMessage());
            }
        }catch (IOException e){
            System.out.println("An IO error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filename = "temp.txt";
        readFile(filename);
    }
}
