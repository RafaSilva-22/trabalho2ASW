package rsa.quad;

import java.util.*;

import static rsa.quad.Trie.Quadrant.*;

public class NodeTrie <T extends HasPoint> extends Trie<T>{

    private Trie<T> northWest;
    private Trie<T> northEast;
    private Trie<T> southWest;
    private Trie<T> southEast;

    final Map<Trie.Quadrant,Trie<T>> tries;

    private final double centerX;
    private final double centerY;

    NodeTrie(double topLeftX, double topLeftY, double bottomRightX, double bottomRightY) {
        super(topLeftX,topLeftY,bottomRightY,bottomRightX);
        tries = new HashMap<>();

        this.centerX = (topLeftX + bottomRightX) / 2;
        this.centerY = (topLeftY + bottomRightY) / 2;

        this.northWest = new LeafTrie<>(topLeftX, topLeftY, centerX, centerY);
        this.northEast = new LeafTrie<>(centerX, topLeftY, bottomRightX, centerY);
        this.southWest = new LeafTrie<>(topLeftX, centerY, centerX, bottomRightY);
        this.southEast = new LeafTrie<>(centerX, centerY, bottomRightX, bottomRightY);
    }

    @Override
    void collectAll(Set<T> points) {
        northWest.collectAll(points);
        northEast.collectAll(points);
        southWest.collectAll(points);
        southEast.collectAll(points);
    }

    @Override
    void collectNear(double x, double y, double radius, Set<T> points) {
        if (northWest.overlaps(x, y, radius)) {
            northWest.collectNear(x, y, radius, points);
        }
        if (northEast.overlaps(x, y, radius)) {
            northEast.collectNear(x, y, radius, points);
        }
        if (southWest.overlaps(x, y, radius)) {
            southWest.collectNear(x, y, radius, points);
        }
        if (southEast.overlaps(x, y, radius)) {
            southEast.collectNear(x, y, radius, points);
        }
    }

    @Override
    void delete(T point) {
        getChildForPoint(point.x(), point.y()).delete(point);
    }

    @Override
    T find(T point) {
        return getChildForPoint(point.x(), point.y()).find(point);
    }

    @Override
    Trie<T> insert(T point) {
        Trie<T> child = getChildForPoint(point.x(), point.y());
        Trie<T> newChild = child.insert(point);

        // Update child reference if it changed (e.g., leaf split into node)
        if (child != newChild) {
            setChildForPoint(point.x(), point.y(), newChild);
        }

        return this;
    }

    private Trie<T> getChildForPoint(double x, double y) {
        if (x < centerX) {
            return y < centerY ? northWest : southWest;
        } else {
            return y < centerY ? northEast : southEast;
        }
    }

    // Helper method to set the appropriate child for a point
    private void setChildForPoint(double x, double y, Trie<T> newChild) {
        if (x < centerX) {
            if (y < centerY) {
                northWest = newChild;
            } else {
                southWest = newChild;
            }
        } else {
            if (y < centerY) {
                northEast = newChild;
            } else {
                southEast = newChild;
            }
        }
    }

    Trie.Quadrant quadrantOf(T point) {
        double x = point.x();
        double y = point.y();

        if (x < centerX) {
            return y < centerY ? NH : SH;
        } else {
            return y < centerY ? NE : SE;
        }
    }

    Collection<Trie<T>> getTries() {
        Set<Trie<T>> children = new LinkedHashSet<>();

        // Add direct children
        children.add(northWest);
        children.add(northEast);
        children.add(southWest);
        children.add(southEast);

        // If any child is a NodeTrie, recursively add its descendants
        if (northWest instanceof NodeTrie) {
            children.addAll(((NodeTrie<T>) northWest).getTries());
        }
        if (northEast instanceof NodeTrie) {
            children.addAll(((NodeTrie<T>) northEast).getTries());
        }
        if (southWest instanceof NodeTrie) {
            children.addAll(((NodeTrie<T>) southWest).getTries());
        }
        if (southEast instanceof NodeTrie) {
            children.addAll(((NodeTrie<T>) southEast).getTries());
        }

        return Collections.unmodifiableCollection(children);
    }

    @Override
    Trie<T> insertReplace(T point) {
        return null;
    }

    @Override
    public void accept(Visitor<T> visitor) {
        visitor.visit(this);
        northWest.accept(visitor);
        northEast.accept(visitor);
        southWest.accept(visitor);
        southEast.accept(visitor);
    }
}
