public interface PricingStrategy {
    double calculatePrice(double basePrice);

    default double calculationTax(double price){
        return 0.05* price; // 5% tax on consumer goods
    }
}
