package PartB;

import java.util.Arrays;
import java.util.List;

class ValidationUtil {

    public static boolean isValidAge(int age) {
        return age >= 18;
    }
}

public class Solution8 {
    public static void main(String[] args) {

        List<Integer> ages = Arrays.asList(12, 18, 25, 15, 30);

        ages.stream()
                .filter(ValidationUtil::isValidAge) // static method reference
                .forEach(System.out::println);
    }
}
