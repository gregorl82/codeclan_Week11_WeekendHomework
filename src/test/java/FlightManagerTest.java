import org.junit.Before;
import org.junit.Test;

import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class FlightManagerTest {

    private FlightManager flightManager;
    private Flight flight;
    private Plane plane;
    private Passenger passenger1;
    private GregorianCalendar departureTime;

    @Before
    public void before(){
        plane = new Plane(PlaneType.CESSNA);
        passenger1 = new Passenger("Bobby Blue", 2);
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
}
