import java.util.*;

class FractionalKnapsack {

    static class Item {
        int weight;
        int value;

        Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    static double getMaxValue(Item[] items, int W) {

        // Sort by value/weight ratio
        Arrays.sort(items, (a, b) ->
                Double.compare(
                        (double)b.value / b.weight,
                        (double)a.value / a.weight
                )
        );

        double totalValue = 0.0;
        int remainingCapacity = W;

        for (Item item : items) {
            if (remainingCapacity == 0)
                break;

            if (item.weight <= remainingCapacity) {
                // Take whole item
                remainingCapacity -= item.weight;
                totalValue += item.value;
            } else {
                // Take fraction
                double fraction =
                        (double) remainingCapacity / item.weight;
                totalValue += item.value * fraction;
                remainingCapacity = 0;
            }
        }
        return totalValue;
    }

    public static void main(String[] args) {
        Item[] items = {
                new Item(10, 60),
                new Item(20, 100),
                new Item(30, 120)
        };

        int W = 50;

        System.out.println("Maximum value in knapsack = "
                + getMaxValue(items, W));
    }
}
