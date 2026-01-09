public abstract class Ride {
    static double basicFare = 100;
    private int distance ;
    private double fareAmount;
    public abstract void calculateFare();

    public static double getBasicFare() {
        return basicFare;
    }

    public static void setBasicFare(double basicFare) {
        Ride.basicFare = basicFare;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public double getFareAmount() {
        return fareAmount;
    }

    public void setFareAmount(double fareAmount) {
        this.fareAmount = fareAmount;
    }

    final double surgeMultiplier(boolean isNight, boolean isPeak){
        if(isNight){
            fareAmount += 100 + fareAmount*0.01; // 100+ 1% of fare during night
        }
        if(isPeak){
            fareAmount += fareAmount*0.2; // 20% extra during peak hours
        }
        return fareAmount;
    }

    final void printFare(){
        if(fareAmount!=0) {
            System.out.println("Your Ride Fare is :"+ fareAmount);
        }
    }
}
