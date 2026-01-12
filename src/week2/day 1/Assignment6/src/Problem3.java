public class Problem3 {
    /*
        3. Age Validator
        Implement a method validateAge(int age) that throws a custom exception
        InvalidAgeException if the age is less than 18. Handle this exception in the calling
        code and print an appropriate message.
     */
    public static boolean validateAge(int age) throws  InvalidAgeException{
        if(age<18){
            throw new InvalidAgeException("Age must be greater than 18");
        }
        return true;
    }
}

class InvalidAgeException extends Exception{
    public InvalidAgeException(String message){
        super(message);
    }
}