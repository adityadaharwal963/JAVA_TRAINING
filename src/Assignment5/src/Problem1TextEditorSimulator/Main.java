package Problem1TextEditorSimulator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Create file and simulator
        TextFile file = new TextFile();
        file.setFileName("sample.txt");
        file.saveFile(""); // initialize empty content

        Simulator simulator = new Simulator(file);

        int choice;

        do {
            System.out.println("Text Editor Simulator");
            System.out.println("1. Append Text");
            System.out.println("2. Insert Text at Cursor Position");
            System.out.println("3. Delete Selected Range");
            System.out.println("4. Move Cursor");
            System.out.println("5. Display Text");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    System.out.print("Enter text to append: ");
                    String appendText = sc.nextLine();
                    simulator.appendText(appendText);
                    break;

                case 2:
                    System.out.print("Enter text to insert: ");
                    String insertText = sc.nextLine();
                    simulator.insertAtCursorPosition(insertText);
                    break;

                case 3:
                    System.out.print("Enter start index: ");
                    int start = sc.nextInt();
                    System.out.print("Enter end index: ");
                    int end = sc.nextInt();
                    simulator.deleteSelectRange(start, end);
                    break;

                case 4:
                    System.out.print("Enter new cursor position: ");
                    int position = sc.nextInt();
                    simulator.setCursorPosition(position);
                    break;

                case 5:
                    simulator.displayText();
                    System.out.println("Cursor Position: " + simulator.getCursorPosition());
                    break;

                case 6:
                    System.out.println("Exiting Text Editor...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 6);

        sc.close();
    }
}
