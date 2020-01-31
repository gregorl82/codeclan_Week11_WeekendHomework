import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class FlightTest {

    private Flight flight;
    private Plane plane;
    private Passenger passenger1;
    private GregorianCalendar departureTime;

    @Before
    public void before(){
        passenger1 = new Passenger("Gertrude Green", 1);
        plane = new Plane(PlaneType.CESSNA);
        departureTime = new GregorianCalendar(2020, 2, 28, 13, 0);
        flight = new Flight("EK028", Airport.DXB, Airport.GLA, plane, departureTime);
    }

    @Test
    public void hasAPlane(){
        assertEquals(plane, flight.getPlane());
    }

    @Test
    public void hasAFlightNumber(){
        assertEquals("EK028", flight.getFlightNumber());
    }

    @Test
    public void startsWithNoPassengers(){
        assertEquals(0, flight.countPassengers());
    }

    @Test
    public void hasADestination(){
        assertEquals(Airport.DXB, flight.getDestination());
    }

    @Test
    public void canGetDestinationName(){
        assertEquals("Dubai", flight.getDestinationNameFromEnum());
    }

    @Test
    public void hasADepartureAirport(){
        assertEquals(Airport.GLA, flight.getDepartureAirport());
    }

    @Test
    public void canGetDepartureAirportName(){
        assertEquals("Glasgow", flight.getDepartureAirportNameFromEnum());
    }

    @Test
    public void hasADepartureTime(){
        assertEquals(departureTime, flight.getDepartureTime());
    }

    @Test
    public void assignedSeatsStartsEmpty(){
        assertEquals(0, flight.countAssignedSeats());
    }

    @Test
    public void canGetNumberOfAvailableSeats(){
        assertEquals(4, flight.getNumberOfAvailableSeats());
    }

    @Test
    public void canBookPassengerOnToFlight(){
        flight.bookPassenger(passenger1);
        assertEquals(1, flight.countPassengers());
        assertEquals(3, flight.getNumberOfAvailableSeats());
        assertEquals("EK028", passenger1.getFlight());
    }

    @Test
    public void cannotBookPassengerIfFlightIsFull(){
        flight.bookPassenger(passenger1);
        flight.bookPassenger(passenger1);
        flight.bookPassenger(passenger1);
        flight.bookPassenger(passenger1);
        flight.bookPassenger(passenger1);
        assertEquals(4, flight.countPassengers());
        assertEquals(0, flight.getNumberOfAvailableSeats());
    }

    @Test
    public void canCountTheNumberOfPassengerBags(){
        flight.bookPassenger(passenger1);
        flight.bookPassenger(passenger1);
        flight.bookPassenger(passenger1);
        assertEquals(3, flight.countPassengerBags());
    }

    @Test
    public void canGenerateRandomSeatNumber(){
        int generatedNumber = flight.generateSeatNumber();
        assertNotNull(generatedNumber);
    }

    @Test
    public void canAssignSeatNumberToPassenger(){
        flight.bookPassenger(passenger1);
        assertNotEquals(0, passenger1.getSeatNumber());
        assertEquals(1, flight.countAssignedSeats());
    }

    @Test
    public void doesNotDoubleBookSeats(){
        flight.bookPassenger(passenger1);
        flight.bookPassenger(passenger1);
        flight.bookPassenger(passenger1);
        flight.bookPassenger(passenger1);
        ArrayList<Integer> bookedSeats = flight.getAssignedSeats();
        Collections.sort(bookedSeats);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        assertEquals(expected, bookedSeats);
    }
}
