package rsa.ride;

import rsa.match.Location;
import rsa.match.RideMatch;
import rsa.quad.HasPoint;
import rsa.user.User;

import java.util.Comparator;

public class Ride implements HasPoint, RideMatchSorter{
    private static User user;
    private static Location to;
    private static Location from;
    private static Location current;
    private static String plate;
    private static float cost;
    private static long nextId = 0;
    private static long id;
    private static RideMatch match;

    public Ride(User user, Location to, Location from, String plate, float cost) {
        Ride.id = nextId++;
        Ride.user = user;
        Ride.to = to;
        Ride.from = from;
        Ride.plate = plate;
        Ride.cost = cost;
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        Ride.user = user;
    }

    public static Location getTo() {
        return to;
    }

    public static void setTo(Location to) {
        Ride.to = to;
    }

    public static Location getFrom() {
        return from;
    }

    public static void setFrom(Location from) {
        Ride.from = from;
    }

    public static String getPlate() {
        return plate;
    }

    public static void setPlate(String plate) {
        Ride.plate = plate;
    }

    public static float getCost() {
        return cost;
    }

    public static void setCost(float cost) {
        Ride.cost = cost;
    }

    public static Location getCurrent() {
        return current;
    }

    public static void setCurrent(Location current) {
        Ride.current = current;
    }

    public long getId() {
        return id;
    }

    public double x() {
        return current.x();
    }

    public double y() {
        return current.y();
    }

    public RideRole getRideRole() {
        if (plate == null) {
            return RideRole.PASSENGER;
        } else {
            return RideRole.DRIVER;
        }
    }

    public boolean isPassenger() {
        if (getRideRole() == RideRole.PASSENGER) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isDriver() {
        if (getRideRole() == RideRole.DRIVER) {
            return true;
        }
        return false;
    }

    public void setMatch(RideMatch match) {
        Ride.match = match;
    }

    public RideMatch getMatch() {
        return match;
    }

    public boolean isMatch() {
        return match != null;
    }


    public Comparator<RideMatch> getComparator() {
        return null; //falta completar
    }




}
