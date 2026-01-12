package models;

import java.util.ArrayList;
import java.util.UUID;

public class Transaction {
    public UUID id;
    private Customer customer;
    private double billAmount;
    private String paymentMethod;
    private ArrayList<Product> purchasedProducts;

    public Transaction(ArrayList<Product> purchasedProducts, String paymentMethod, double billAmount, Customer customer) {
        this.purchasedProducts = purchasedProducts;
        this.paymentMethod = paymentMethod;
        this.billAmount = billAmount;
        this.customer = customer;
    }
}
