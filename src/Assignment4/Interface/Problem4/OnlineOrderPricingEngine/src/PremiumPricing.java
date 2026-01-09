public class PremiumPricing implements PricingStrategy {
    @Override
    public double calculatePrice(double basePrice) {
        System.out.println("Premium Pricing fro Premium Products");
        double productPrice = basePrice + 0.45*basePrice; // Premium Pricing 45% overhead;
        return productPrice + calculationTax(productPrice);
    }
}
