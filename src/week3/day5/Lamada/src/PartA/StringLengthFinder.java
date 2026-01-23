package PartA;

import java.util.*;

public class StringLengthFinder {
    public static void main(String[] args) {

        List<String> strings = Arrays.asList(
                "apple", "banana", "cherry", "kiwi", "pineapple"
        );

        strings.stream()
                .filter(s -> s.length() > 5)
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}

