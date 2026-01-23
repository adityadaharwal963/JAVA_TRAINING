import java.util.*;
public class CountGreaterThanX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(sc.nextInt());

        long count = list.stream().filter(num -> num > x).count();
        System.out.println(count);
    }
}
