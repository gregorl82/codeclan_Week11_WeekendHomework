public class Plane {

    private PlaneType type;

    public Plane(PlaneType type) {
        this.type = type;
    }

    public PlaneType getPlaneType() {
        return type;
    }

    public int getCapacityFromEnum() {
        return this.type.getCapacity();
    }

    public int getTotalWeightFromEnum() {
        return this.type.getTotalWeight();
    }
}
