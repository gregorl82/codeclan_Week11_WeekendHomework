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
