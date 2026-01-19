import java.util.HashSet;
import java.util.Set;

public class NonRepeatingSubstring {
    static void lengthOfLongestSubstring(String str){
        Set<Character> charSet = new HashSet<>();
        char[] string = str.toCharArray();
        int length = 1;
        int subStringStart = 0;
        for(int i=1;i<str.length();i++){
            if(charSet.contains(string[i])){
                while (charSet.contains(string[i])) {
                    charSet.remove(string[subStringStart]);
                    subStringStart++;
                }
            }else {
                charSet.add(string[i]);
                length = Math.max(length,i-subStringStart);
            }
        }
        System.out.println("length: "+length);
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring("abcabcbb");
        lengthOfLongestSubstring("aabb");
    }
}
