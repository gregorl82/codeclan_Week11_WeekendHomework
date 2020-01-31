import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {

    private Plane plane;

    @Before
    public void before(){
        plane = new Plane(PlaneType.CESSNA);
    }

    @Test
    public void canGetPlaneType(){
        assertEquals(PlaneType.CESSNA, plane.getPlaneType());
    }

    @Test
    public void canGetPlaneCapacity(){
        assertEquals(4, plane.getCapacityFromEnum());
    }

    @Test
    public void canGetPlaneWeight(){
        assertEquals(320, plane.getTotalWeightFromEnum());
    }
}
