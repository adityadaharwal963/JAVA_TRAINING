public class BikeRide extends  Ride{
    String bikeType;
    @Override
    public void calculateFare() {
        double fareAmount = switch (bikeType) {
            case "Regular" -> this.getDistance() * 5;
            case "Standard" -> this.getDistance() * 10;
            default -> 0;
        };
        this.setFareAmount(fareAmount);
    }
}
