import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class FlightManagerTest {

    private FlightManager flightManager;
    private Flight flight;
    private Plane plane;
    private Passenger passenger1;
    private Passenger passenger2;
    private Passenger passenger3;
    private Passenger passenger4;
    private GregorianCalendar departureTime;

    @Before
    public void before(){
        plane = new Plane(PlaneType.CESSNA);

        passenger1 = new Passenger("Bobby Blue", 2);
        passenger2 = new Passenger("Yoann Yellow", 2);
        passenger3 = new Passenger("Polly Purple", 2);
        passenger4 = new Passenger("Michael Mauve", 1);

        departureTime = new GregorianCalendar(2020, 1, 1, 8, 0);

        flight = new Flight("AB123", Airport.EDI, Airport.GLA, plane, departureTime);

        flightManager = new FlightManager();
    }

    @Test
    public void canCalculateAvailableWeightForBaggage(){
        assertEquals(160, flightManager.getTotalAvailableWeight(flight));
    }

    @Test
    public void canCalculatePassengersBaggageWeight(){
        flight.bookPassenger(passenger1);
        flight.bookPassenger(passenger1);
        assertEquals(80, flightManager.getWeightOfPassengerBaggage(flight));
    }

    @Test
    public void canCalculateRemainingWeightForBaggage(){
        flight.bookPassenger(passenger1);
        assertEquals(120, flightManager.getRemainingWeightForBaggage(flight));
    }

    @Test
    public void outputSortedPassengerNumbers(){
        // Book in 4 passengers and sort by seat number
        flight.bookPassenger(passenger1);
        flight.bookPassenger(passenger2);
        flight.bookPassenger(passenger3);
        flight.bookPassenger(passenger4);
        flightManager.sortPassengersBySeatNumber(flight);

        // Check each of the passengers are in seat order
        ArrayList<Passenger> sortedPassengers = flight.getPassengers();
        assertEquals(1, sortedPassengers.get(0).getSeatNumber());
        assertEquals(2, sortedPassengers.get(1).getSeatNumber());
        assertEquals(3, sortedPassengers.get(2).getSeatNumber());
        assertEquals(4, sortedPassengers.get(3).getSeatNumber());
    }

    @Test
    public void canGetPassengerBySeatNumber(){
        flight.bookPassenger(passenger1);
        flight.bookPassenger(passenger2);
        flight.bookPassenger(passenger3);
        flight.bookPassenger(passenger4);
        Passenger foundPassenger = flightManager.getPassengerBySeatNumber(flight, 2);
        assertEquals(2, foundPassenger.getSeatNumber());
    }

    @Test
    public void cannotFindPassenger(){
        Passenger foundPassenger = flightManager.getPassengerBySeatNumber(flight, 1);
        assertNull(foundPassenger);
    }
}
