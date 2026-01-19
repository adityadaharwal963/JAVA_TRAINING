public class PalindromeSentence {

    // Complexity
    // time O(n)
    // Space O(n)
    static  void isPalindrome(String sentence){
        sentence = sentence.toLowerCase();
        char[] chars = new char[sentence.length()];
        int len = 0;
        for(int i=0;i<sentence.length();i++){
            if(Character.isAlphabetic(sentence.charAt(i)) || Character.isDigit(sentence.charAt(i))){
                chars[len]= sentence.charAt(i);
                len++;
            }
        }

        boolean isPalindrome = true;
        for(int i=0;i<len/2;i++){
            if(chars[i]!=chars[len-1-i]){
                isPalindrome= false;
                break;
            }
        }
        System.out.println("String: "+ sentence);

        if(isPalindrome){
            System.out.println("is Palindrome");
        }else{
            System.out.println("is Not Palindrome");
        }

    }

    public static void main(String[] args) {
        isPalindrome("a man, a plan, a canal : Panama");
        isPalindrome("race a car");
    }
}
