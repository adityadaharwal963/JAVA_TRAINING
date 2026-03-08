import java.util.HashMap;
import java.util.HashSet;

class Solution3719 {
    class Result{
        HashSet<Integer> even;
        HashSet<Integer> odd;
        int max;

    }

    public Result segment(int[] nums, int l , int r){
        Result rs = new Result();
        rs.even = new HashSet<>();
        rs.odd = new HashSet<>();
        if(l==r){
            if(nums[l]%2==0){
                rs.even.add(nums[l]);
            }else{
                rs.odd.add(nums[l]);
            }
            rs.max = 0;
            return rs;
        }

        int mid = l + (r-l)/2;
        Result left = segment(nums, l, mid-1);
        Result right = segment(nums, mid, r);

        rs.even.addAll(left.even);
        rs.even.addAll(right.even);
        rs.odd.addAll(left.odd);
        rs.odd.addAll(right.odd);
        if(rs.even.size()==rs.odd.size()){
            rs.max = r-l+1;
        }else{
            rs.max = Math.max(left.max,right.max);
        }
        return rs;

    }
    public int longestBalanced(String s) {
        int longest = Integer.MIN_VALUE;

        for(int i=0;i<s.length();i++){
            int curr_max = 0;
            int curr_max_freq = 0;
            HashMap<Character,Integer> freq = new HashMap<>();
            for(int j = i;j<s.length();j++){
                freq.put(s.charAt(j),freq.getOrDefault(s.charAt(j),0)+1);
                if(curr_max_freq <= freq.get(s.charAt(j)) ){
                    if(new HashSet<>(freq.values()).size() == 1){
                        curr_max = j-i+1;
                    }
                    curr_max_freq = freq.get(s.charAt(j));
                }

            }
            longest = Math.max(curr_max,longest);
        }
        return longest;
    }

    public static void main(String[] args) {
        Solution3719 sol = new Solution3719();
        System.out.println(sol.longestBalanced("aaabbbcccdddde"));
    }
}