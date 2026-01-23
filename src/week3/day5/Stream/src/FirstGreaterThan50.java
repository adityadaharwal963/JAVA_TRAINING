import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class FirstGreaterThan50 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(sc.nextInt());

        list.stream()
                .filter(x -> x > 50)
                .findFirst()
                .ifPresent(System.out::println);
    }
}
