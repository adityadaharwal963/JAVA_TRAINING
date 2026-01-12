public class Problem5 {
    public static boolean authenticate(String username , String password) throws  AuthenticationException{

        // authentication logic
        if(!username.equals("user") || !password.equals("12234")){
            throw new AuthenticationException("Invalid Username or password, Please try again");
        }
        //authenticated
        return true;
    }
}

class AuthenticationException extends Exception{
    public AuthenticationException(String message){
        super(message);
    }
}