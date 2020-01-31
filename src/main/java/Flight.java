import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Random;

public class Flight {

    private String flightNumber;
    private Airport destination;
    private Airport departureAirport;
    private Plane plane;
    private GregorianCalendar departureTime;
    private ArrayList<Passenger> passengers;
    private ArrayList<Integer> assignedSeats;

    public Flight(String flightNumber, Airport destination, Airport departureAirport, Plane plane, GregorianCalendar departureTime) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureAirport = departureAirport;
        this.plane = plane;
        this.departureTime = departureTime;
        this.passengers = new ArrayList<>();
        this.assignedSeats = new ArrayList<>();
    }

    public Plane getPlane() {
        return plane;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public Airport getDestination() {
        return destination;
    }

    public String getDestinationNameFromEnum() {
        return destination.getName();
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public String getDepartureAirportNameFromEnum() {
        return departureAirport.getName();
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public int countPassengers() {
        return passengers.size();
    }

    public GregorianCalendar getDepartureTime() {
        return departureTime;
    }

    public ArrayList<Integer> getAssignedSeats() {
        return assignedSeats;
    }

    public int getNumberOfAvailableSeats() {
        return plane.getCapacityFromEnum() - countPassengers();
    }

    public void bookPassenger(Passenger passenger) {
        if(getNumberOfAvailableSeats() > 0){
            int seatNumber = generateSeatNumber();
            while (assignedSeats.contains(seatNumber)){
                seatNumber = generateSeatNumber();
            }
            passenger.setSeatNumber(seatNumber);
            passenger.setFlight(flightNumber);
            passengers.add(passenger);
            assignedSeats.add(seatNumber);
        }
    }

    public int countPassengerBags() {
        int numberOfBags = 0;
        for (Passenger passenger : passengers){
            numberOfBags += passenger.getNumberOfBags();
        }
        return numberOfBags;
    }

    public int countAssignedSeats() {
        return assignedSeats.size();
    }

    public int generateSeatNumber() {
        int totalSeats = plane.getCapacityFromEnum();
        Random rand = new Random();
        int seatNumber = rand.nextInt(totalSeats) + 1;
        return seatNumber;
    }

}
