import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class AverageSalary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(sc.nextInt());

        double avg = list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();
        System.out.println(avg);
    }
}
