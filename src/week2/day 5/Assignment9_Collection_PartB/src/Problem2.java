import java.util.ArrayList;
import java.util.HashSet;

public class Problem2 {

    /*
    Movie Ticket Booking System
    Scenario:
    A multiplex wants to maintain seat bookings.
    Requirements:
     Seats are numbered (1–100)
     Booked seats must be unique
     Display available seats after booking
    Hint:
    Use HashSet<Integer>
     */

    static HashSet<Integer> availableSeats = new HashSet<>();

    static void initMultiplex(){
        for(int i=1;i<=100;i++){
            availableSeats.add(i);
        }
    }

    static void bookSeat(ArrayList<Integer> booking){
        availableSeats.removeAll(booking);
    }

    static void displayAvailableSeats(){
        System.out.println(availableSeats);
    }

    public static void main(String[] args) {
        initMultiplex();
        displayAvailableSeats();
        // book seat from 30 to 100
        ArrayList<Integer> booking = new ArrayList<>();
        for(int i=30;i<=100;i++){
            booking.add(i);
        }
        bookSeat(booking);
        System.out.println("Seats after booking:");
        displayAvailableSeats();

    }
}
