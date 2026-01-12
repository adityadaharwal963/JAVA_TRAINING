public class FestivalPricing implements PricingStrategy {
    @Override
    public double calculatePrice(double basePrice) {
        System.out.println("Festival Sale Pricing ");
        double productPrice = basePrice - 0.10*basePrice;  // Festival Pricing 10% Discount
        return productPrice + calculationTax(productPrice);
    }
}
