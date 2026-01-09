import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;
        int distance;
        do {
            System.out.println("Ride Booking Menu");
            System.out.println("1. Bike Ride");
            System.out.println("2. Cab Ride");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    BikeRide bike = new BikeRide();

                    System.out.print("Enter distance (km): ");
                    distance = sc.nextInt();
                    bike.setDistance(distance);
                    System.out.print("Enter Bike Type (Regular / Standard): ");
                    bike.bikeType = sc.next();

                    bike.calculateFare();
                    bike.printFare();

                    System.out.print("Is it night ride? (true/false): ");
                    boolean bikeNight = sc.nextBoolean();

                    System.out.print("Is it peak hour? (true/false): ");
                    boolean bikePeak = sc.nextBoolean();

                    System.out.println("After Surge :");
                    bike.surgeMultiplier(bikeNight, bikePeak);
                    bike.printFare();
                    break;

                case 2:
                    System.out.print("Enter Car Type (Mini / Sedan / SUV): ");
                    String carType = sc.next();

                    CabRide cab = new CabRide(carType);

                    System.out.print("Enter distance (km): ");
                    distance = sc.nextInt();
                    cab.setDistance(distance);
                    cab.calculateFare();
                    cab.printFare();

                    System.out.print("Is it night ride? (true/false): ");
                    boolean cabNight = sc.nextBoolean();

                    System.out.print("Is it peak hour? (true/false): ");
                    boolean cabPeak = sc.nextBoolean();


                    System.out.println("After Surge :");
                    cab.surgeMultiplier(cabNight, cabPeak);
                    cab.printFare();
                    break;

                case 3:
                    System.out.println("Thank you for using Ride Booking App!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 3);

        sc.close();
    }
}
