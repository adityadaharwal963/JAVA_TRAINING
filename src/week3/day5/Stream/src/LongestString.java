import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
public class LongestString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(sc.next());

        String longest =
                list.stream()
                        .max(Comparator.comparingInt(String::length))
                        .get();

        System.out.println(longest);
    }
}
