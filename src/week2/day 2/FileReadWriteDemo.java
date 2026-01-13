import java.io.*;

public class FileReadWriteDemo {
    public static void demo(){

        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));

        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("temp.txt"));
            boolean choice;
            do {
                System.out.println("Enter source address:");
                String source = inputReader.readLine();
                BufferedReader bufferedReader = new BufferedReader(new FileReader(source));
                String content = bufferedReader.readLine();
                while (content != null) {
                    bufferedWriter.write(content);
                    content = bufferedReader.readLine();
                }
                System.out.println("Do You want enter from more sources (yes/no):");
                choice = inputReader.readLine().equals("yes");
                bufferedReader.close();
            }while (choice);
            bufferedWriter.close();

        }catch (IOException e){
            System.out.println("IO Exception: "+ e.getMessage());
        }
    }

    public static void main(String[] args) {
        demo();
    }
}
