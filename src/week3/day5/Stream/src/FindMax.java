import java.util.*;
public class FindMax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(sc.nextInt());

        int max = list.stream()
                .max(Integer::compare)
                .get();
        System.out.println(max);

    }
}
