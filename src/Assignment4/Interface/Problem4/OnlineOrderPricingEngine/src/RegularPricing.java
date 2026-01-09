public class RegularPricing implements PricingStrategy {
    @Override
    public double calculatePrice(double basePrice) {
        System.out.println("Off Season Regular Pricing");
        return basePrice + calculationTax(basePrice); // regular price
    }
}
