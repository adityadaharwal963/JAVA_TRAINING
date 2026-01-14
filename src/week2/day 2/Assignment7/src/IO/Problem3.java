import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem3 {
    /*
    Problem Statement: Develop a program that asks the user for a list of tasks (e.g., a
    to-do list) using the Scanner class and saves them to a file (tasks.txt). Then, read back
    the tasks from the file using BufferedReader and display them on the console.
    Requirements:
    ● Use BufferedWriter to save the tasks to the file.
    ● Use BufferedReader to read the tasks from the file.
     */

    static void tasksWriter(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter task (to exit enter EXIT):");
        ArrayList<String> tasks = new ArrayList<>();
        String input;
        boolean choice = true;

        // take input of tasks from cmd
        while (choice){
            input = sc.nextLine().trim();
            choice = !input.equalsIgnoreCase("EXIT");
            if(choice)
                tasks.add(input);
        }

        //write to task file
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("tasks.txt"))){
            for(String task:tasks){
                bw.write(task);
                bw.newLine();
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        // print tasks to cmd
        try(BufferedReader br = new BufferedReader(new FileReader("tasks.txt"))){
            System.out.println("Tasks:");
            String task = br.readLine();
            while(task!=null){
                System.out.println(task);
                task = br.readLine();
            }
        }catch(FileNotFoundException e){
            System.out.println("Source File not found");
        } catch(IOException e){
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        tasksWriter();
    }
}
