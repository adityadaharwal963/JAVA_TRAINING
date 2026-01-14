import java.util.ArrayList;

public class Problem4 {
    /*
    Shopping Cart Application (List)
    Objective
    Manage products in a shopping cart.
    Tasks
    1. Add items to an ArrayList.
    2. Remove one item.
    3. Update quantity of an item.
    4. Display the final cart.
    Concepts Used
    ArrayList, List
     */

    // ArrayList to  store shopping cart items
    final private static ArrayList<Item> items = new ArrayList<>();

    static void addItem(Item item){
        items.add(item);
    }

    static void removeItem(String productName){
        // remove item by search product name
        items.removeIf(item -> item.getProductName().equals(productName));
    }

    static void updateItemQuantity(String productName , int quantity){
        // iterate list
        for(Item item: items){
            // search by product name
            if (item.getProductName().equals(productName)){
                // set updated quantity
                item.setQuantity(quantity);
            }
        }
    }

    static void displayCart(){
        int totalAmount = 0;
        System.out.println("Cart Summary:");
        for(Item item:items){
            System.out.println(item);
            totalAmount += item.getPrice()*item.getQuantity();
        }
        System.out.println("Total Amount: "+ totalAmount);
    }

    public static void main(String[] args) {
        // add items to cart
        items.add(new Item("A",100,2));
        items.add(new Item("B",120,2));
        items.add(new Item("C",190,2));
        items.add(new Item("D",140,2));
        items.add(new Item("E",190,2));

        displayCart();
        //updated quantity
        updateItemQuantity("A",10);
        displayCart();

        //remove items
        removeItem("C");
        removeItem("B");
        displayCart();
    }
}

class Item{
    private String productName;
    private int price;
    private int quantity;

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public Item(String productName, int price, int quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return
                "productName='" + productName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity
                ;
    }
}