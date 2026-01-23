import java.util.HashMap;

public class CountSubarrays{
        public int subarraySum(int[] nums, int k) {
            HashMap<Integer,Integer> prefix = new HashMap<>();
            int total_sum = 0; // count prefix sum at each step
            int count = 0; // result

            // for subarray 0 t i
            prefix.put(total_sum, prefix.getOrDefault(total_sum,0)+1);
            for(int i=0;i<nums.length;i++){
                total_sum += nums[i]; // 1
                if(prefix.containsKey(total_sum-k)){ // -1
                    // check how many prefix sum has difference k from current sum
                    count += prefix.get(total_sum-k);
                }

                // as nums can be negative , prefix sum repeats , so we count there occurance
                prefix.put(total_sum, prefix.getOrDefault(total_sum,0)+1);

            }

            return count;
        }
    }