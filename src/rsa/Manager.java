package rsa;

import rsa.match.Location;
import rsa.match.Matcher;
import rsa.match.PreferredMatch;
import rsa.match.RideMatch;
import rsa.ride.Ride;
import rsa.ride.RideRole;
import rsa.user.User;
import rsa.user.UserStars;

import java.util.List;
import java.util.Set;

public class Manager extends Object {
    private static Manager instance;
    private User user;

    // Private constructor for Singleton
    private Manager() {
        // Initialization code here
    }

    public static synchronized Manager getInstance() {
        if (instance == null) {
            instance = new Manager();
        }
        return instance;
    }

    public User register(String nick, String name) {
        return new User(nick, name);
    }

    public PreferredMatch getPreferredMatch(String nick, String Key) {
        return null;
    }

    public void setPreferredMatch(String nick,
                                  String key,
                                  PreferredMatch preferred){

    }

    public long addRide(String nick,
                        String key,
                        Location from,
                        Location to,
                        String plate,
                        float cost){
        Ride ride = new Ride(user, from , to , plate,cost);

        return ride.getId();
    }

    public Set<RideMatch> updateRide(long rideId,
                                     Location current){
        return null;
    }


    public void acceptMatch(long rideId,
                            long matchId){

    }

    public void concludeRide(long rideId,
                             UserStars classification){

    }

    public double getAverage(String nick,
                             RideRole role){
        return 0;
    }
}
