import java.util.ArrayList;

public class Flight {

    private String flightNumber;
    private Airport destination;
    private Airport departureAirport;
    private Plane plane;
    private ArrayList<Passenger> passengers;

    public Flight(String flightNumber, Airport destination, Airport departureAirport, Plane plane) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureAirport = departureAirport;
        this.plane = plane;
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
        return this.passengers.size();
    }
}
