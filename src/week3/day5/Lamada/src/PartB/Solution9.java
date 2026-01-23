package PartB;

import java.util.Arrays;
import java.util.List;

class TextProcessor {

    // Instance method
    public void printUpper(String text) {
        System.out.println(text.toUpperCase());
    }
}

public class Solution9 {
    public static void main(String[] args) {

        List<String> words = Arrays.asList("java", "lambda", "method reference");

        TextProcessor processor = new TextProcessor();

        words.forEach(processor::printUpper); // instance method reference
    }
}
