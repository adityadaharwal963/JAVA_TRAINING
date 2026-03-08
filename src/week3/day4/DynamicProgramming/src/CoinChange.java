import java.util.Arrays;

public class CoinChange {
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int[] dp  = new int[amount+1];
            Arrays.fill(dp,amount+1);
            dp[0] = 0;

            for(int i=1;i<=amount;i++){
                for(int j=0;j<coins.length;j++){
                    if(i>=coins[j]){
                        dp[i] = Math.min(dp[i],1 + dp[ i - coins[j]]);
                    }
                }
            }
            if(dp[amount]==amount+1){
                return -1;
            }
            return dp[amount];
        }
    }

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(Character.isAlphabetic(s.charAt(i)) || Character.isDigit(s.charAt(i))){
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        return sb.reverse().toString().equals(s);
    }
}
