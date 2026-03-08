import java.util.HashMap;
import java.util.Objects;

class Solution3714 {

    static class MyPair{
        int fs;
        int st;
        MyPair(int fs , int st){
            this.fs = fs;
            this.st = st;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof MyPair)) return false;
            MyPair p = (MyPair) o;
            return fs == p.fs &&
                    st == p.st;
        }

        @Override
        public int hashCode() {
            return Objects.hash(fs, st);
        }
    }

    static int singleLongest(String s,char c){
        int max = 0;
        if(s.charAt(0)==c){
            max = 1;
        }
        int curr = max;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==c){
                curr++;
            }else{
                curr = 0;
            }
            max = Math.max(curr,max);
        }
        return max;
    }

    static int doubleLongest(String s,char first, char second,char third){

        int[] prefix = new int[s.length()];
        int start = -1;
        while(s.charAt(start+1)==third && start<s.length()-1){
            start++;
        }
        if(s.charAt(start+1)==first){
            prefix[start+1] = 1;
        }else if(s.charAt(start+1)==second){
            prefix[start+1] = -1;
        }
        int max = 0;

        for(int i=1;i<s.length();i++){
            prefix[i] = prefix[i-1];
            if(s.charAt(i) == first){
                prefix[i] += 1;
            }else if(s.charAt(i) == second){
                prefix[i] += -1;
            }else{
                prefix[i] = 0;
                start = i;
            }
            if(prefix[i]==0 && i!= start){
                max = Math.max(i-start ,max);
            }
        }
        return max;
    }

    static int tripleLongest(String s){
        HashMap<MyPair,Integer> prefix_set = new HashMap<>();
        int a =0,b=0,c=0;
        int max = 0;
        prefix_set.put(new MyPair(0,0),-1);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) - 'a' == 0){
                a++;
            }else if(s.charAt(i) - 'b' == 0){
                b++;
            }else if(s.charAt(i) - 'c' == 0){
                c++;
            }
            int ab = a - b;
            int bc = b - c;
            MyPair p = new MyPair(ab,bc);
            if(prefix_set.containsKey(p)){
                int ind = prefix_set.get(p);
                max = Math.max(i-ind,max);
            }else{
                prefix_set.put(p,i);
            }
        }
        return max;
    }

    public int longestBalanced(String s) {
        int single = Math.max(singleLongest(s,'c'),Math.max(singleLongest(s,'b'),singleLongest(s,'a')));
        int ab = doubleLongest(s,'a', 'b');
        int bc = doubleLongest(s,'b', 'c');
        int ca = doubleLongest(s,'c', 'a');
        int doub = Math.max(ab,Math.max(bc,ca));
        int t = tripleLongest( s);
        int result = Math.max(t,single);
        result = Math.max(t,doub);
        return result;
    }
    public static void main(String[] args) {
        Solution3714 sol = new Solution3714();
        System.out.println(sol.longestBalanced("abcbc"));
    }
}