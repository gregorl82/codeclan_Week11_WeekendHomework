public enum PlaneType {

    CESSNA(4, 320),
    LEARJET(20, 400),
    AIRBUSA320(119, 1600),
    AIRBUSA350(249, 19920),
    AIRBUSA380(412, 32960),
    BOEING737(135, 1800),
    BOEING747(384, 30720),
    BOEING787(298, 23840);

    private int capacity;
    private int totalWeight;

    PlaneType(int capacity, int totalWeight) {
        this.capacity = capacity;
        this.totalWeight = totalWeight;
    }

}
