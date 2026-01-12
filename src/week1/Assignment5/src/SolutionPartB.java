import java.time.*;
import java.time.format.DateTimeFormatter;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SolutionPartB {

    static Scanner sc = new Scanner(System.in);

    // Age Calculator
    static void problem1() {
        System.out.print("Enter Date of Birth (yyyy-MM-dd): ");
        String dobStr = sc.nextLine();

        LocalDate dob = LocalDate.parse(dobStr);
        LocalDate today = LocalDate.now();

        int age = Period.between(dob, today).getYears();
        System.out.println("Current Age: " + age);
    }

    // Event Countdown
    static void problem2() {
        System.out.print("Enter Future Date (yyyy-MM-dd): ");
        String futureDateStr = sc.nextLine();

        LocalDate futureDate = LocalDate.parse(futureDateStr);
        LocalDate today = LocalDate.now();

        Period period = Period.between(today, futureDate);
        int daysLeft = period.getDays();

        System.out.println("Days left for event: " + daysLeft);
    }

    // Attendance Formatter
    static void problem3() {
        System.out.print("Enter Attendance Date (yyyy-MM-dd): ");
        String dateStr = sc.nextLine();

        LocalDate date = LocalDate.parse(dateStr);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");

        System.out.println("Formatted Date: " + date.format(formatter));
    }

    // Email Validator
    static void problem4() {
        System.out.print("Enter Email ID: ");
        String email = sc.nextLine();

        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        boolean isValid = Pattern.matches(regex, email);

        System.out.println("Email Valid: " + isValid);
    }

    //Password Strength Checker
    static void problem5() {
        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        String regex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        boolean isStrong = Pattern.matches(regex, password);

        System.out.println("Strong Password: " + isStrong);
    }

    //Mobile Number Validator
    static void problem6() {
        System.out.print("Enter Mobile Number: ");
        String mobile = sc.nextLine();

        String regex = "^[6-9]\\d{9}$";
        boolean isValid = Pattern.matches(regex, mobile);

        System.out.println("Mobile Number Valid: " + isValid);
    }

    // 7. Currency Formatter
    static void problem7() {
        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        NumberFormat indiaFormat = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
        NumberFormat usFormat = NumberFormat.getCurrencyInstance(Locale.US);

        System.out.println("Indian Format: " + indiaFormat.format(salary));
        System.out.println("US Format: " + usFormat.format(salary));
    }

    // Main method to test
    public static void main(String[] args) {
        problem1();
        problem2();
        problem3();
        problem4();
        problem5();
        problem6();
        problem7();
    }
}
