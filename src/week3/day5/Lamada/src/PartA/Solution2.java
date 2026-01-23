package PartA;

import java.util.*;

class Product {
    int productId;
    String productName;
    double price;

    Product(int productId, String productName, double price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    @Override
    public String toString() {
        return productId + " | " + productName + " | ₹" + price;
    }
}



public class Solution2 {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        products.add(new Product(101, "Laptop", 65000));
        products.add(new Product(102, "Mobile", 25000));
        products.add(new Product(103, "Tablet", 30000));
        products.add(new Product(104, "Headphones", 4000));
        products.add(new Product(105, "Camera", 55000));

        // Sort by price (ascending)
        Collections.sort(products,
                (p1, p2) -> Double.compare(p1.price, p2.price));

        System.out.println("Sorted by Price (Ascending):");
        products.forEach(System.out::println);

        // Sort by product name (descending)
        Collections.sort(products,
                (p1, p2) -> p2.productName.compareTo(p1.productName));

        System.out.println("\nSorted by PartA.Product Name (Descending):");
        products.forEach(System.out::println);
    }
}
