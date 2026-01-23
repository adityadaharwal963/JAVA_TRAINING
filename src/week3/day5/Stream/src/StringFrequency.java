import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StringFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(sc.next());

        Map<String, Long> map =
                list.stream()
                        .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        map.forEach((k,v) -> System.out.println(k + "=" + v));
    }
}
