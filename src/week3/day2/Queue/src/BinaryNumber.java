
import java.util.LinkedList;
import java.util.Queue;

public class BinaryNumber {
    static void generateBinary(int N) {
        Queue<String> q = new LinkedList<>();
        q.add("1");

        for (int i = 1; i <= N; i++) {
            String current = q.poll();
            System.out.print(current + " ");

            q.add(current + "0");
            q.add(current + "1");
        }
    }

    public static void main(String[] args) {
        int N = 5;
        generateBinary(N);
    }
}

