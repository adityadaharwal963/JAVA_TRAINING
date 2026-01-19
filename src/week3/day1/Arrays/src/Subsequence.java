public class Subsequence {

    // Complexity
    // Time O(n)
    // Space O(1)
    static void isSubsequence(String string, String seq){
        int seq_index = 0;
        for(char c: string.toCharArray()){
            if(c==seq.charAt(seq_index)){
                seq_index++;
                if(seq_index==seq.length()){
                    break;
                }
            }

        }

        System.out.println(string+" "+seq);
        if(seq_index==seq.length()){
            System.out.println("True");
        }else {
            System.out.println("False");
        }
    }

    public static void main(String[] args) {
        isSubsequence("abcde","cde");
        isSubsequence("aec","abcde");
    }
}
