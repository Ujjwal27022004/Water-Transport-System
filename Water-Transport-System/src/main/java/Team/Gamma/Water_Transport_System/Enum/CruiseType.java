package Team.Gamma.Water_Transport_System.Enum;

public enum CruiseType {
    FAMILY("Family Cruise"),
    DELUXE("Deluxe Cruise"),
    LUXURY("Luxury Cruise"),
    PREMIUM("Premium Cruise");

    private final String description;

    CruiseType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
