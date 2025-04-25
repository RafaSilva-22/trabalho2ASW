package rsa.match;

import rsa.ride.Ride;
import rsa.user.User;

import java.io.Serializable;

public class Matcher implements Serializable {

    private static Location topLeft;
    private static double radius;
    private static Location bottomRight;


    public Matcher(){

    }

    public static void setTopLeft(Location topLeft) {
        Matcher.topLeft = topLeft;
    }
    public void setRadius(double radius) {
        Matcher.radius = radius;
    }
    public void setBottomRight(Location bottomRight) {
        Matcher.bottomRight = bottomRight;
    }
    public Location getTopLeft() {
        return topLeft;
    }
    public double getRadius() {
        return radius;
    }
    public Location getBottomRight() {
        return bottomRight;
    }

    public long addRide(User user, Location from, Location to, String plate, float cost) {
        Ride ride = new Ride(user, from, to, plate, cost);
        return ride.getId();
    }
}
