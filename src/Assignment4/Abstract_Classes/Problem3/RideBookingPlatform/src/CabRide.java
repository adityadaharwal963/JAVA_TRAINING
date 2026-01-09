public class CabRide extends  Ride{
    String carType;
    CabRide(String carType){
        this.carType = carType;
    }

    @Override
    public void calculateFare() {
        double fareAmount  = switch (carType) {
            case "Mini" -> this.getDistance() * 10;
            case "Sedan" -> this.getDistance() * 15;
            case "SUV" -> this.getDistance() * 20;
            default -> 0;
        };
        this.setFareAmount(fareAmount);
    }
}
