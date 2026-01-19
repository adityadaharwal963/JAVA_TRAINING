public class FirstNonRepeating {

    // Complexity
    // Time O(n)
    // Space O(1)
    static void firstNonRepeating(String s) {
        char[] array = s.toLowerCase().toCharArray();
        int[] arr = new int[26];
        for(int i=0;i<array.length;i++){
            arr[(int)array[i]-97]++;
        }

        for(int i=0;i<26;i++){
           if(arr[i]==1){
               System.out.println("First Non repeating element: "+(char)(i+97));
               return;
           }
        }

        System.out.println("No Char found");
    }

    static void firstRepeating(String s) {
        char[] array = s.toLowerCase().toCharArray();
        int[] arr = new int[26];
        for(int i=0;i<array.length;i++){
            arr[(int)array[i]-97]++;
        }

        for(int i=0;i<26;i++){
            if(arr[i]==2){
                System.out.println("First  repeating element: "+(char)(i+97));
                return;
            }
        }

        System.out.println("No Char found");
    }

    public static void main(String[] args) {
        firstNonRepeating("aabbc");
        firstRepeating("cdfgaabb");
    }
}
