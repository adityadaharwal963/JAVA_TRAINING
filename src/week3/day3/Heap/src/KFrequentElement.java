import java.util.*;

public class KFrequentElement {
    static void kFrequentElement(int[] arr , int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i: arr){
            if(map.containsKey(i)){
                map.put(i,map.get(i)-1);
            }else {
                map.put(i,-1);
            }
        }

        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(Comparator.comparing(Map.Entry::getValue));
        pq.addAll(map.entrySet());
        System.out.println(Arrays.toString(pq.toArray()));
        while (!pq.isEmpty() && k>0){
            System.out.println(pq.poll().getKey());
            k--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,3,4,2,2,2,3,3,2};
        kFrequentElement(arr,2);
    }
}
