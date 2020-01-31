import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightTest {

    private Flight flight;
    private Plane plane;
    private Passenger passenger1;

    @Before
    public void before(){
        plane = new Plane(PlaneType.CESSNA);
        flight = new Flight("EK028", Airport.DXB, Airport.GLA, plane, "13:00 28FEB2020");
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
        assertEquals("13:00 28FEB2020", flight.getDepartureTime());
    }

    @Test
    public void canGetNumberOfAvailableSeats(){
        assertEquals(4, flight.getNumberOfAvailableSeats());
    }

}
