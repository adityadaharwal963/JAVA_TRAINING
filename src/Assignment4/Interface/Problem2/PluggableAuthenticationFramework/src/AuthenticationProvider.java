public interface AuthenticationProvider {
    boolean authenticate(String userId, String credential);

    static boolean validateUserIdFormat(String userId){
        return userId.startsWith("HIJ/") && userId.endsWith("01");
    };
}
