import java.util.Arrays;

public class RodCuttingProblem {

        static int rodCut(int[] price, int n, int[] dp) {
            // Base case
            if (n == 0)
                return 0;

            // If already computed
            if (dp[n] != -1)
                return dp[n];

            int maxVal = 0;

            // Try all possible cuts
            for (int i = 1; i <= n; i++) {
                maxVal = Math.max(maxVal, price[i - 1] + rodCut(price, n - i, dp));
            }

            dp[n] = maxVal;
            return dp[n];
        }

        public static void main(String[] args) {
            int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
            int N = 8;

            int[] dp = new int[N + 1];
            Arrays.fill(dp, -1);

            System.out.println("Maximum Revenue = " + rodCut(price, N, dp));
        }
}
