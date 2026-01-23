import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
public class PartitionEvenOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(sc.nextInt());

        Map<Boolean, List<Integer>> map =
                list.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0));

        System.out.println("Even: " + map.get(true));
        System.out.println("Odd: " + map.get(false));
    }
}
