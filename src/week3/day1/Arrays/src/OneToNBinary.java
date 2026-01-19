public class OneToNBinary {

    // Complexity
    // Time O(n)
    // Space O(1)
    static void printBinary(int n){
        for(int i=1;i<=n;i++){
            System.out.print(Integer.toBinaryString(i)+" ");
        }
    }
}
