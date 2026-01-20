package IO;

import java.io.*;

public class Problem1 {
    /*
    Problem Statement: Write a Java program to copy the contents of a text file
    (source.txt) to another file (destination.txt) using FileInputStream and
    FileOutputStream. Ensure the program handles exceptions like
    FileNotFoundException and IOException.
     */

    // transfer content from source to destination
    static void transferContent(String source , String destination){

        try {
            FileInputStream inputStream = new FileInputStream(source);
            FileOutputStream outputStream = new FileOutputStream(destination);
            byte[] lines = inputStream.readAllBytes();
            outputStream.write(lines);
            inputStream.close();
            outputStream.close();
        }catch (FileNotFoundException e){
            System.out.println("Source File Not Found");
        }catch (IOException e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        transferContent("IO/source.txt", "IO/destination");
    }
}
