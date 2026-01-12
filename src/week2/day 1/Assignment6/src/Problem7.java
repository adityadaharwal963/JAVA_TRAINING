import java.io.FileWriter;
import java.io.IOException;

public class Problem7 {

    /*
    7. Resource Management
        Develop a program to write data to a file using FileWriter. Ensure that the file
        resource is properly closed by using a finally block or a try-with-resources
        statement.
     */
    public static  void customFileWriter(){
        String filename = "output.txt";
        String content = "Hello first time trying try-with-resource";
        // try-with-resource statement
        try(FileWriter fileWriter = new FileWriter(filename)){
            fileWriter.write(content);// write content to file
            System.out.println("Data successfully written to " + filename);
        }catch (IOException e){
            System.err.println("An I/O error occurred: " + e.getMessage());
        }
    }
}
