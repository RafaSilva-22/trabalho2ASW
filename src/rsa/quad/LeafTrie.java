package rsa.quad;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class LeafTrie <T extends HasPoint> extends Trie<T> {

    private final Set<T> points;

    LeafTrie(double topLeftX, double topLeftY, double bottomRightX, double bottomRightY){
        super(topLeftX,topLeftY,bottomRightY,bottomRightX);
        this.points = new HashSet<>();
    }

    @Override
    void collectAll(Set<T> points) {
        this.points.addAll(points);
    }

    @Override
    void collectNear(double x, double y, double radius, Set<T> nodes) {
        double radiusSquared = radius * radius;
        for (T point : nodes) {
            double dx = x - point.x();
            double dy = y - point.y();
            if (dx * dx + dy * dy <= radiusSquared) {
                nodes.add(point);
            }
        }
    }

    @Override
    void delete(T point) {
        points.remove(point);
    }

    @Override
    T find(T point) {
        for (T p : points) {
            if (p.x() == point.x() && p.y() == point.y()) {
                return p;
            }
        }
        return null;
    }

    @Override
    Trie<T> insert(T point) {
        points.add(point);
        return null;
    }

    @Override
    Trie<T> insertReplace(T point) {
        // First remove any existing point at same location
        T existing = find(point);
        if (existing != null) {
            points.remove(existing);
        }

        // Then insert the new point
        return insert(point);
    }

    @Override
    public void accept(Visitor<T> visitor) {
        visitor.visit(this);
    }

    Collection<T> getPoints() {
        return points;
    }

}
