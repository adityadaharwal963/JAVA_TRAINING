import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class SquareNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(sc.nextInt());

        list.stream()
                .map(x -> x * x)
                .forEach(x -> System.out.print(x + " "));
    }
}
