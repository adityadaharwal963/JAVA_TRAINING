import java.util.Scanner;

public class SectionFive {
    /*
    Wrapper Classes
    17. Boxing and Unboxing
        ○ Write a program to demonstrate:
        ■ Boxing a primitive int into an Integer object.
        ■ Unboxing the Integer object back to an int.
    18. Auto-boxing and Auto-unboxing
        ○ Create a program to add primitive int values to a list of Integer type using auto-
    boxing, and calculate the sum using auto-unboxing.
    19. Data Conversion
        ○ Write a program that takes a string input of a number and converts it into:
        ■ int using Integer.parseInt().
        ■ double using Double.parseDouble().
        ■ long using Long.parseLong().
    20. Primitive-to-Wrapper Comparison
        ○ Create a program to compare primitive int and wrapper Integer values using
        .equals() and == operators.
     */
    static void problem_17(){
        int a = 10;
        Integer b = new Integer(a);//Boxing , note @Deprecated since = "9"
        int c = b.intValue(); // unBoxing

        System.out.println(b.getClass()+" "+b);
    }
    static void problem_18(){
        int a = 10;
        Integer b = a;//Auto Boxing , note @Deprecated since = "9"
        int c = b; // auto unBoxing

        System.out.println(b.getClass()+" "+b);
    }
    static void problem_19(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a Number:");
        String numberString = sc.next();
        Integer integer =  Integer.parseInt(numberString);
        System.out.println(integer.getClass());
        Double doubles = Double.parseDouble(numberString);
        System.out.println(doubles.getClass());
        Long longs = Long.parseLong(numberString);
        System.out.println(longs.getClass());
        sc.close();
    }
    static void problem_20(){
        int a = 10;
        Integer b = 10;
        if(a==b){
            System.out.println("Equal");
        }
        if(b.equals(a)){
            System.out.println("Equal");
        }
    }

}
