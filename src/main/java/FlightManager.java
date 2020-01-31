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

    public void sortPassengersBySeatNumber(Flight flight) {
        int length = flight.countPassengers();

        for(int i = 0; i < length - 1; i++){

            for(int j = 1; j < length - i; j++){
                Passenger firstPassenger = flight.getPassengers().get(j-1);
                Passenger secondPassenger = flight.getPassengers().get(j);
                if(firstPassenger.getSeatNumber() > secondPassenger.getSeatNumber()){
                    flight.getPassengers().set(j-1, secondPassenger);
                    flight.getPassengers().set(j, firstPassenger);
                }
            }

        }
    }
}
