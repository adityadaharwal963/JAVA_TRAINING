import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Problem2 {
    /*
    2. File Reader
        Create a program to read the contents of a file. Handle exceptions like
        FileNotFoundException and IOException. If the file is not found, prompt the user to
        provide a valid file path
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

        }catch (IOException e){
            System.out.println("An IO error occurred: " + e.getMessage());
        }
    }
}
