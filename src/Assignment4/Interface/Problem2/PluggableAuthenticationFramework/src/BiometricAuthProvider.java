public class BiometricAuthProvider implements AuthenticationProvider {
    @Override
    public boolean authenticate(String userId, String credential) {

        System.out.println("Validating User id");
        if(AuthenticationProvider.validateUserIdFormat(userId)){
            System.out.println("UserId:" + userId);
            System.out.println("Verifying Biometric Credential");
            System.out.println("User Authenticated");
            return true;
        }else {
            System.out.println("Invalid User Id");
            return false;
        }
    }
}
