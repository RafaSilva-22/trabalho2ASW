package rsa.quad;

import java.util.Set;

public abstract class Trie <T extends HasPoint> implements Element<T> {
    protected final double topLeftX;
    protected final double topLeftY;
    protected final double bottomRightY;
    protected final double bottomRightX;

    private static int capacity;

    protected Trie(double topLeftX, double topLeftY, double bottomRightX, double bottomRightY) {
        this.topLeftX = topLeftX;
        this.topLeftY = topLeftY;
        this.bottomRightY = bottomRightY;
        this.bottomRightX = bottomRightX;
    }

    static void setCapacity(int capacity) {
        Trie.capacity = capacity;
    }
    static int getCapacity() {
        return Trie.capacity;
    }
    public static double getDistance(double x1, double y1, double x2, double y2) {
        double dx = x1 - x2;
        double dy = y1 - y2;
        return Math.sqrt(dx * dx + dy * dy);
    }

    protected boolean overlaps(double x, double y, double radius) {
        // Find the closest point on the rectangle to the circle center
        double closestX = clamp(x, topLeftX, bottomRightX);
        double closestY = clamp(y, topLeftY, bottomRightY);

        // Calculate distance between circle center and closest point
        double distanceX = x - closestX;
        double distanceY = y - closestY;

        // Check if the distance is less than the radius
        return (distanceX * distanceX + distanceY * distanceY) <= (radius * radius);
    }

    private double clamp(double value, double min, double max) {
        return Math.max(min, Math.min(max, value));
    }

    abstract void collectAll(Set<T> points);
    abstract void collectNear(double x, double y, double radius, Set<T> points);
    abstract void delete(T point);
    abstract T find(T point);
    abstract Trie<T> insert(T point);
    abstract Trie<T> insertReplace(T point);




    public enum Quadrant {
        NE,
        NH,
        SE,
        SH;
    }


}
