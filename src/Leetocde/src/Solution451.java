import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution451 {
    public static void addChar(StringBuilder sb, char ch,int i) {
        while (i-- > 0) {
            sb.append(ch);
        }
    }
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        s.chars().forEach(c -> {map.put((char)c,map.getOrDefault((char)c,0)+1);});
        StringBuilder sb = new StringBuilder();
        map.entrySet().stream().sorted((a,b)->b.getValue().compareTo(a.getValue())).forEachOrdered(e -> addChar(sb,e.getKey(),e.getValue()));
        return sb.toString();
    }

    static void main() {
        Solution451 solution = new Solution451();
    }
}
