package rsa.match;

import rsa.ride.Ride;
import rsa.ride.RideRole;
import rsa.user.Car;

public class RideMatch extends Object {
    private Ride left;
    private Ride right;
    private Car car;
    private float cost;
    private long id;

    RideMatch(Ride left, Ride right) {
        this.left = left;
        this.right = right;
    }

    public Car getCar() {
        return car;
    }

    public float getCost() {
        return cost;
    }

    public long getId() {
        return id;
    }

    private Ride getRide(RideRole role) {
        return (getRole() == role) ? left : right;
    }

    public RideRole getRole() {
        return this.left.isDriver() ? RideRole.DRIVER : RideRole.PASSENGER;
    }





}
