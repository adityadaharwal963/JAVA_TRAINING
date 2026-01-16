import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Problem9 {
    /*
    Library Book Issuing System
    Scenario:
    A library tracks books issued to students.
    Requirements:
     Store student name and list of issued books
     Allow issuing multiple books
     Display books issued to a specific student
    Hint:
    Use Map<String, List<String>>
     */

    static HashMap<String, List<String>> bookData = new HashMap<>();

    static void displayBooks(String studentName){
        System.out.println("Book published by Student: "+studentName);
        if(bookData.containsKey(studentName)){
            for(String book:bookData.get(studentName)){
                System.out.println(book);
            }
        }else {
            System.out.println("No Books published");
        }
    }

    static void publishBooks(String studentName, String[] books){

        if(bookData.containsKey(studentName)){
              bookData.get(studentName).addAll(Arrays.asList(books));
        }else {
            bookData.put(studentName,Arrays.asList(books));
        }
    }

    public static void main(String[] args) {
        // get some book list that student wants to publish
        String[] bookList1 ={"as","the","legend","told"};
        String[] bookList2 ={"by","legend"};
        String[] bookList3 ={"a","legend","by legend"};
        // students publish some books
        publishBooks("Ram",bookList1);
        publishBooks("Sam",bookList2);
        publishBooks("Gopu",bookList3);

        //Display books publish by Ram
        displayBooks("Ram");
    }
}
