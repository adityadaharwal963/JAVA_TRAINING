import java.util.HashSet;

public class LongestConsecutiveSequence {
    // complexity O(n)
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hashset = new HashSet<>();
        // create set of numbers
        for(int i : nums){
            hashset.add(i);
        }
        int longest = 0;

        for(int i : nums){
            int curr_longest = 1;
            // check possible sequence
            if(hashset.contains(i+1) || hashset.contains(i-1)){
                int temp = i;
                hashset.remove(temp);
                // check elements forward
                while(hashset.contains(temp+1)){
                    curr_longest++;
                    hashset.remove(temp+1);
                    temp++;
                }
                temp = i;
                // check elements backward
                while(hashset.contains(temp-1)){
                    curr_longest++;
                    hashset.remove(temp-1);
                    temp--;
                }

            }
            longest = Math.max(longest,curr_longest);
        }

        return longest;
    }
}
