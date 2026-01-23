import java.util.*;
public class UppercaseStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(sc.next());

        list.stream()
                .map(String::toUpperCase)
                .forEach(s -> System.out.print(s + " "));
    }
}
