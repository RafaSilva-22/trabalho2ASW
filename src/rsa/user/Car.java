package rsa.user;

public class Car {
    private String plate;
    private String make;
    private String model;
    private String color;

    public Car(String plate, String make, String model, String color) {
        this.plate = plate;
        this.make = make;
        this.model = model;
        this.color = color;
    }

    public String getPlate() {
        return plate;
    }
    public String getMake() {
        return make;
    }
    public String getModel() {
        return model;
    }
    public String getColor() {
        return color;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }
    public void setMake(String make) {
        this.make = make;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setColor(String color) {
        this.color = color;
    }

}
