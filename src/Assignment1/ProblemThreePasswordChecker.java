package Assignment2;


import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
// Password Checker
public class ProblemThreePasswordChecker {
    // check if password Strength
    public static void checkPasswordStrength(String password) {
        int n = password.length();
        boolean hasLower = false, hasUpper = false,
                hasDigit = false, specialChar = false;
        Set<Character> set = new HashSet<Character>(
                Arrays.asList('!', '@', '#', '$', '%', '^', '&',
                        '*', '(', ')', '-', '+'));
        for (char i : password.toCharArray()) {
            if (Character.isLowerCase(i))
                hasLower = true;
            if (Character.isUpperCase(i))
                hasUpper = true;
            if (Character.isDigit(i))
                hasDigit = true;
            if (set.contains(i))
                specialChar = true;
        }

        // Strength of password

        System.out.print("Strength of password:- ");
        if (hasDigit && hasLower && hasUpper && specialChar
                && (n >= 8))
            System.out.print("Strong");
        else {
            System.out.print("Weak");
        }
    }

    public void test() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Password to check Security");
        String password = sc.next();
        checkPasswordStrength(password);
        sc.close();
    }
}
