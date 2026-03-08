public class LongestCommonSequence {
        public static String longestCommonSubsequence(String text1, String text2) {

            int n = text1.length()+1;
            int m = text2.length()+1;
            int[][] table = new int[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(i==0 || j==0){
                        table[i][j]= 0;
                    }else{
                        table[i][j] = Math.max(table[i-1][j],table[i][j-1]);
                        if(text1.charAt(i-1)== text2.charAt(j-1)){
                            table[i][j] = table[i-1][j-1]+1;
                        }
                    }
                }
            }

            StringBuilder sb = new StringBuilder();

            int i=n-1,j=m-1;
            while(i>0 && j>0){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    sb.append(text1.charAt(i-1));
                    i--;
                    j--;
                }
                else if(table[i-1][j]>table[i][j-1]){
                    i--;
                }else {
                    j--;
                }
            }


            return sb.reverse().toString();
        }

    static void main() {
        String t1 = "abcde";
        String t2 = "acvde";
        System.out.println(longestCommonSubsequence(t1,t2));
    }
}
