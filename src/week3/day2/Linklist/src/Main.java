import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LinkList<Integer> list = new LinkList<>();

        int choice;

        do {
            System.out.println("\n--- Linked List Menu ---");
            System.out.println("1. Add element");
            System.out.println("2. Traverse list");
            System.out.println("3. Delete by value");
            System.out.println("4. Delete by position");
            System.out.println("5. Remove duplicates");
            System.out.println("6. Reverse list");
            System.out.println("7. Reverse from position");
            System.out.println("8. Detect loop");
            System.out.println("9. Find middle node");
            System.out.println("10. Remove Nth node from end");
            System.out.println("11. Check palindrome");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter value to add: ");
                    list.add(sc.nextInt());
                    break;

                case 2:
                    System.out.print("Linked List: ");
                    list.traverse();
                    System.out.println();
                    break;

                case 3:
                    System.out.print("Enter value to delete: ");
                    list.delete(sc.nextInt());
                    break;

                case 4:
                    System.out.print("Enter position to delete: ");
                    list.deletePosition(sc.nextInt());
                    break;

                case 5:
                    list.removeDuplicate();
                    System.out.println("Duplicates removed.");
                    break;

                case 6:
                    list.reverse();
                    System.out.println("List reversed.");
                    break;

                case 7:
                    System.out.print("Enter position to reverse from: ");
                    int pos = sc.nextInt();
                    LinkNode<Integer> node = list.head;
                    int i = 0;
                    while (node != null && i < pos) {
                        node = node.next;
                        i++;
                    }
                    if (node != null) {
                        list.reverseFromNode(node);
                        System.out.println("Reversed from position " + pos);
                    } else {
                        System.out.println("Invalid position");
                    }
                    break;

                case 8:
                    list.detectLoop();
                    list.makeCircular();
                    list.detectLoop();
                    break;

                case 9:
                    LinkNode<Integer> middle = list.middleNode();
                    if (middle != null) {
                        System.out.println("Middle node value: " + middle.value);
                    }
                    break;

                case 10:
                    System.out.print("Enter N (from end): ");
                    list.removeNthFromEnd(sc.nextInt());
                    System.out.println("Nth node from end removed.");
                    break;

                case 11:
                    list.isPalindrome();
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        sc.close();
    }
}
