package models;

import java.util.UUID;

public class Product {
    public UUID productId;
    private String price;
    private String supplier;

    public Product(String price, String supplier) {
        this.productId =UUID.randomUUID();
        this.price = price;
        this.supplier = supplier;
    }
}
