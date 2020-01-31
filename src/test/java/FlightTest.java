import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightTest {

    private Flight flight;

    @Before
    public void before(){
        flight = new Flight();
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

}
