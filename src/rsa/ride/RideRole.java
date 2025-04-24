package rsa.ride;

public enum RideRole {
    DRIVER("driver"),
    PASSENGER("passenger");

    private final String role;

    RideRole(String passenger) {
        this.role = passenger;
    }

    public RideRole other() {
        return this == DRIVER ? PASSENGER : DRIVER;
    }



}
