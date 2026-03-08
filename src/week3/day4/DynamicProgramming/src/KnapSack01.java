import java.util.Arrays;

public class KnapSack01 {
    static void helper(int[] dp,int[] values,int[] weights,int capacity,int weight_sum,int value_sum,int i){
        if(i==weights.length) return;
        if( weight_sum+weights[i]<=capacity){
            dp[weights[i]+ weight_sum] = Math.max(dp[weights[i]+ weight_sum],values[i]+value_sum);
            helper(dp,values,weights,capacity,weight_sum+weights[i],values[i]+value_sum,i+1);
        }

        helper(dp,values,weights,capacity,weight_sum,value_sum,i+1);
    }
    static int knapSack(int[] values, int[] weights, int capacity) {
        int[] dp = new int[capacity + 1];
        helper(dp,values,weights,capacity,0,0,0);
        int max_value = Integer.MIN_VALUE;
        for (int i = 1; i <= capacity; i++) {
            max_value = Math.max(max_value,dp[i]);
        }
        return max_value;
    }

    static void main(){
        int[] values = {1,2,3};
        int[] weights = {4,5,6};
        int capacity = 3;
        System.out.println(knapSack(values, weights, capacity));

    }
}
