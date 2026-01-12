import java.util.Scanner;
/*
    6. Number Conversion
    Write a program that converts a string to an integer using Integer.parseInt(). If
    the input string is invalid (non-numeric), handle the NumberFormatException and
    prompt the user to enter a valid number.
 */
public class Problem6 {
    public static void stringToInteger() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Pls enter String Integer :");
        String integerString = sc.next();
        try {
            int integerValue = Integer.parseInt(integerString);
            System.out.println("Integer Value :" + integerValue);
        } catch (NumberFormatException e) {
            System.out.println(" pls enter valid integer");
            Problem6.stringToInteger();
        } catch (Exception e) {
            System.out.println("Unhandled error occurred:" + e.getMessage());
        }
    }
}
