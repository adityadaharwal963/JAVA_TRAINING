import java.util.LinkedHashMap;
import java.util.Map;

public class Problem8 {
    /*
    . Order History Tracker
    Concept: LinkedHashMap
    Scenario
    An e-commerce system stores customer orders in the exact order they were placed.
    Task
    1. Store order ID and product name.
    2. Display all orders in insertion order.
    3. Remove a cancelled order. 
     */

    final private  static LinkedHashMap<String,String> orders = new LinkedHashMap<>();
    static void displayOrders(){
        // LinkHashMap Maintains order of insertion
        for(Map.Entry<String,String> log: orders.entrySet()){
            System.out.println(log.getKey()+" "+log.getValue());
        }
    }

    static void deleteOrder(String orderId){
        if(orders.containsKey(orderId)){
            System.out.println("Deleted order Product Name:");
            System.out.println(orders.get(orderId));
            orders.remove(orderId);
        }else {
            System.out.println("Order not Found");
        }
    }

    public static void main(String[] args) {
        // Add login orders
        orders.put("123","ball");
        orders.put("342", "apple");
        orders.put("324","mooc");
        // display Ordered Logs
        displayOrders();

        // delete a cancel order
        deleteOrder("324");

        displayOrders();
    }
}
