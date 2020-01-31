public class FlightManager {

    public int getTotalAvailableWeight(Flight flight) {
        return flight.getPlane().getTotalWeightFromEnum()/2;
    }

    public int getWeightOfPassengerBaggage(Flight flight) {
        return flight.countPassengerBags() * 20;
    }

    public int getRemainingWeightForBaggage(Flight flight) {
        return getTotalAvailableWeight(flight) - getWeightOfPassengerBaggage(flight);
    }
}
