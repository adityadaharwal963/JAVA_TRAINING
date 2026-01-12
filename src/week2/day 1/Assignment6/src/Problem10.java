import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem10 {
    /*
    10. User Registration
        Create a user registration program:
        ● Validate the user's email format using regular expressions.
        ● Throw a custom InvalidEmailException if the format is incorrect.
        ● Use a try-catch block to handle this exception and ask the user to re-enter a
        valid email.
        regular expression email: ^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$
     */

    final static Pattern EMAIL_PATTERN =  Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    public static void validateEmail() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Pls Enter Email :");
        String email = sc.next();

        try {
            if(isValidEmail(email)){
                System.out.println("Valid Email Address");
            }
        } catch (InvalidEmailException e) { // handle exception
            System.out.println(e.getMessage());
            // ask the user to re-enter a valid email
            Problem10.validateEmail();
        } catch (Exception e) {
            System.out.println("Unhandled error occurred:" + e.getMessage());
        }
    }

    static boolean isValidEmail(String email) throws InvalidEmailException{
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        if(!matcher.matches()){
            throw new InvalidEmailException("Invalid Email Format");
        }
        return true;
    }

    public static void main(String[] args) {
        validateEmail();
    }
}

class InvalidEmailException extends Exception{
    public InvalidEmailException(String msg){
        super(msg);
    }
}