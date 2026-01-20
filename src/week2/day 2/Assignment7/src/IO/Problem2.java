package IO;

import java.io.*;

public class Problem2 {
    /*
    Problem Statement: Create a program to read a list of names (one name per line)
        from a file (names.txt) and write only the names starting with a specific letter (e.g., "A")
        into another file (filtered_names.txt).
        Requirements:
        ● Use FileReader and FileWriter.
        ● Ensure proper exception handling and resource management using try-with-
        resources.
     */

    static  void writeNamesStartWithA(String namesFile, String destinationFile) {

        try (FileReader fr = new FileReader(new File(namesFile))) {
            BufferedReader bufferedReader = new BufferedReader(fr);
            BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFile));
            String name = bufferedReader.readLine();
            while (name != null){
                System.out.println(name);
                if (name.startsWith("A")) {
                    writer.write(name);
                    writer.newLine();
                }
                name = bufferedReader.readLine();
            }
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Source File not found");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        writeNamesStartWithA("IO/names.txt", "IO/filtered_names.txt");
    }
}
