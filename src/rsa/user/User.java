package rsa.user;

import rsa.match.PreferredMatch;
import rsa.ride.RideRole;

public class User {
    private String name;
    private String nick;
    private PreferredMatch preferredMatch;
    private Car car;
    private String key;


    public User(String name, String nick) {
        this.name = name;
        this.nick = nick;
    }

    public String getName() {
        return name;
    }
    public String getNick() {
        return nick;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setNick(String nick) {
        this.nick = nick;
    }
    public void addCar(Car car) {
        this.car = car;
    }

    public String getKey() {
        return key;
    }
    public String generateKey() {
        this.key = key;
    }

    public boolean authenticate(String key){
        if(this.key.equals(key)){return true;}
        return false;
    }
    public Car getCar(String plate) {
        return car;
    }
    void deleteCar(String plate) {}

    public PreferredMatch getPreferredMatch() {
        return preferredMatch;
    }

    public void setPreferredMatch(PreferredMatch preferredMatch) {
        this.preferredMatch = preferredMatch;
    }

    public void addStars(UserStars stars, RideRole role) {

    }

    public float getAverage(RideRole role) {
        return 0;
    }



}
