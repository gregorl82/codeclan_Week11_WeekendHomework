import java.util.ArrayList;

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

    public Passenger getPassengerBySeatNumber(Flight flight, int seatNumber){
        sortPassengersBySeatNumber(flight);
        ArrayList<Passenger> passengers = flight.getPassengers();
        return binarySearch(passengers, seatNumber);
    }

    public Passenger binarySearch(ArrayList<Passenger> passengers, int search_number){
        if (passengers.size() == 0){
            return null;
        }

        int midIndex = 0;

        if (passengers.size() > 1){
            midIndex = (int)Math.ceil((double)passengers.size()/2);
        }

        Passenger midPoint = passengers.get(midIndex);

        if (midPoint.getSeatNumber() == search_number){
            return midPoint;
        }

        ArrayList<Passenger> subSetOfPassengers;

        if (midPoint.getSeatNumber() > search_number){
            subSetOfPassengers = new ArrayList<>(passengers.subList(0, midIndex));
        } else {
            subSetOfPassengers = new ArrayList<>(passengers.subList(midIndex+1, passengers.size()));
        }

        return binarySearch(subSetOfPassengers, search_number);
    }
}
