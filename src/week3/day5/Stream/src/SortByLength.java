import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;
public class SortByLength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(sc.next());

        list.stream()
                .sorted(Comparator.comparingInt(String::length))
                .forEach(s -> System.out.print(s + " "));
    }
}
