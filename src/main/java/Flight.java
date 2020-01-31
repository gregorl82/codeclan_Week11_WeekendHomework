import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Flight {

    private String flightNumber;
    private Airport destination;
    private Airport departureAirport;
    private Plane plane;
    private GregorianCalendar departureTime;
    private ArrayList<Passenger> passengers;

    public Flight(String flightNumber, Airport destination, Airport departureAirport, Plane plane, GregorianCalendar departureTime) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureAirport = departureAirport;
        this.plane = plane;
        this.departureTime = departureTime;
        this.passengers = new ArrayList<>();
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

    public int countPassengers() {
        return passengers.size();
    }

    public GregorianCalendar getDepartureTime() {
        return departureTime;
    }

    public int getNumberOfAvailableSeats() {
        return plane.getCapacityFromEnum() - countPassengers();
    }

    public void bookPassenger(Passenger passenger) {
        if(getNumberOfAvailableSeats() > 0){
            passengers.add(passenger);
        }
    }

    public int countPassengerBags() {
        int numberOfBags = 0;
        for (Passenger passenger : passengers){
            numberOfBags += passenger.getNumberOfBags();
        }
        return numberOfBags;
    }
}
