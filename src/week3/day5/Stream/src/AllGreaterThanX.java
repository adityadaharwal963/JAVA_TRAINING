import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class AllGreaterThanX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(sc.nextInt());
        int x = sc.nextInt();

        System.out.println(list.stream().allMatch(sal -> sal > x));
    }
}
