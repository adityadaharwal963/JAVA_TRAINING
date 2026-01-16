import java.util.ArrayList;

public class Problem1 {
    /*
    1. Java List Operations
    Problem Statement:
    You are given an empty ArrayList<Integer>. Perform a series of queries of the following
    types:
     Insert x y → Insert element y at index x
     Delete x → Delete the element at index x
    Input:
     First line: Integer N (number of initial elements)
     Next N integers
     Next line: Integer Q (number of queries)
     Next Q lines: queries
    Output:
    Print the final list.
     */

    static ArrayList<Integer> list = new ArrayList<>();
    static  void performQuery(String query){
        try {
            String[] action = query.split(" ");
            if (query.startsWith("Insert")) {
                list.add(Integer.parseInt(action[1]),Integer.parseInt(action[2])); //Insert element y at index x
            } else if (query.startsWith("Delete")) {
                list.remove(Integer.parseInt(action[1])); // remove at index x
            } else {
                System.out.println("Invalid Choice");
            }
        }catch (IndexOutOfBoundsException e){
            System.out.println("Invalid query format");
        }
    }

    static void displayList(){
        for(Integer i: list){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        performQuery("Insert 0 1");
        performQuery("Insert 0 2");
        performQuery("Insert 0 3");
        performQuery("Insert 0 4");
        performQuery("Insert 0 1");
        displayList();
        performQuery("Delete 1");
        displayList();

    }
}
