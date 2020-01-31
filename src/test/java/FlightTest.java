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
    private Passenger passenger2;
    private Passenger passenger3;
    private Passenger passenger4;
    private GregorianCalendar departureTime;
    private ArrayList<Integer> expectedSeatNumbers;

    @Before
    public void before(){
        passenger1 = new Passenger("Gertrude Green", 1);
        passenger2 = new Passenger("Yoann Yellow", 2);
        passenger3 = new Passenger("Polly Purple", 2);
        passenger4 = new Passenger("Michael Mauve", 1);

        plane = new Plane(PlaneType.CESSNA);
        departureTime = new GregorianCalendar(2020, 2, 28, 13, 0);
        flight = new Flight("EK028", Airport.DXB, Airport.GLA, plane, departureTime);
        expectedSeatNumbers = new ArrayList<>();
        expectedSeatNumbers.add(1);
        expectedSeatNumbers.add(2);
        expectedSeatNumbers.add(3);
        expectedSeatNumbers.add(4);
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
        assertEquals(expectedSeatNumbers, bookedSeats);
    }


    @Test
    public void outputSortedPassengerNumbers(){
        // Book in 4 passengers and sort by seat number
        flight.bookPassenger(passenger1);
        flight.bookPassenger(passenger2);
        flight.bookPassenger(passenger3);
        flight.bookPassenger(passenger4);
        flight.sortPassengersBySeatNumber();

        // Pull out seat numbers and assign to a new ArrayList
        ArrayList<Integer> output = new ArrayList<>();
        for(Passenger passenger : flight.getPassengers()){
            output.add(passenger.getSeatNumber());
        }

        // Check against [1, 2, 3, 4]
        assertEquals(expectedSeatNumbers, output);
    }
}
