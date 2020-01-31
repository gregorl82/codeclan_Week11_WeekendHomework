public enum Airport {

    AMS("Amsterdam"),
    CDG("Paris"),
    DXB("Dubai"),
    EDI("Edinburgh"),
    GLA("Glasgow"),
    HND("Tokyo-Haneda"),
    LAX("Los Angeles"),
    LGW("London-Gatwick"),
    LHR("London-Heathrow"),
    JFK("New York-JFK"),
    MAD("Madrid"),
    NRT("Tokyo-Narita"),
    ORD("Chicago"),
    PEK("Beijing-Capital"),
    SFO("San Francisco");

    private String name;

    Airport(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
