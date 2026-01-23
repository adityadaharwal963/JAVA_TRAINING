import java.util.*;

class Solution {

    static String signature(String str){
        char[] string = str.toCharArray();
        TreeMap<Character, Integer> freq = new TreeMap<>();
        for(char c: string){
            freq.put(c,freq.getOrDefault(c,0)+1);
        }
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character, Integer> v : freq.entrySet()){
            sb.append(v.getKey());
            sb.append(v.getValue());
        }
        return sb.toString();
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> strings = new HashMap<>();

        for(String s : strs){
            String sign = signature(s);
            if(!strings.containsKey(sign)){
                strings.put(sign,new ArrayList<String>());
            }
            strings.get(sign).add(s);
        }

        List<List<String>> result = new ArrayList<List<String>>();
        result.addAll(strings.values());
        return result;
    }
}