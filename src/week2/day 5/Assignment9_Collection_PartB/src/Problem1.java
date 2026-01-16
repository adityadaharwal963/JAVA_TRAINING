import java.util.LinkedHashSet;

public class Problem1 {
    /*
    Scenario:
    An e-commerce application stores products added to a user’s cart.
    Requirements:
     Store product names in the order added
     Do not allow duplicate products
     Allow removal of a product
     Display final cart items
    Hint:
    Use LinkedHashSet<String>

     */
    static LinkedHashSet<String> cart = new LinkedHashSet<>();

    static void addProduct(String product){
        if (!cart.contains(product)) {
            cart.add(product);
        }else {
            System.out.println("Already exist");
        }

    }
    static void removeProduct(String product){
        if (!cart.contains(product)) {
            System.out.println("Not Found");
        }else {
            cart.remove(product);
        }
    }

    static void displayCart(){
        System.out.println("Cart Items:");
        for(String product:cart){
            System.out.println(product);
        }
    }

    public static void main(String[] args) {
        // add product
        addProduct("Oil");
        addProduct("Coil");
        addProduct("Mine");
        addProduct("choco");

        displayCart();

        removeProduct("Oil");
        displayCart();
    }


}
