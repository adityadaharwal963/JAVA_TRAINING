package PartB;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Customer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Customer{name='" + name + "'}";
    }
}


public class Solution10 {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        // Constructor method reference
        List<Customer> customers = names.stream()
                .map(Customer::new)
                .toList();

        customers.forEach(System.out::println);
    }
}
