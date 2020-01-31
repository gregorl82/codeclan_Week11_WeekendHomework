import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightManagerTest {

    private FlightManager flightManager;
    private Flight flight;
    private Plane plane;
    private Passenger passenger1;

    @Before
    public void before(){
        plane = new Plane(PlaneType.CESSNA);
        passenger1 = new Passenger("Bobby Blue", 2);
        flight = new Flight("AB123", Airport.EDI, Airport.GLA, plane, "08:00 01JAN2020");
        flightManager = new FlightManager(flight);
    }

    @Test
    public void hasFlightToManage(){
        assertEquals(flight, flightManager.getFlight());
    }
}
