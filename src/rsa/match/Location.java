package rsa.match;

public class Location {
    private final double x;
    private final double y;

    public Location(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double x() {
        return x;
    }
    public double y() {
        return y;
    }

    public final int hashCode() {
        return (int) (x * 31 + y);
    }

    @Override
    public final String toString() {
        return super.toString();
    }

    public final boolean equals(Object o) {
        if (this == o) return true;
        return o != null && getClass() == o.getClass();
    }
}
