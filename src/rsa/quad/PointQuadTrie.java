package rsa.quad;

import rsa.RideSharingAppException;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class PointQuadTrie <T extends HasPoint> extends Object implements Iterable<T> {

    private Trie<T> top;
    private final double topLeftX;
    private final double topLeftY;
    private final double bottomRightX;
    private final double bottomRightY;

    public PointQuadTrie(double topLeftX, double topLeftY, double bottomRightX, double bottomRightY){
        this.topLeftX = topLeftX;
        this.topLeftY = topLeftY;
        this.bottomRightX = bottomRightX;
        this.bottomRightY = bottomRightY;
        this.top = new LeafTrie<>(topLeftX, topLeftY, bottomRightX, bottomRightY);
    }

    @Override
    public Iterator<T> iterator() {
        return new PointIterator();
    }

    public void delete(T point) {
        //top = top.delete(point);
    }

    public T find(T point) {

        return top.find(point);
    }

    public Set<T> findNear(double x, double y, double radius) {


        Set<T> points = new LinkedHashSet<>();
        top.collectNear(x, y, radius, points);
        return Collections.unmodifiableSet(points);
    }

    public Set<T> getAll() {
        Set<T> points = new LinkedHashSet<>();
        top.collectAll(points);
        return Collections.unmodifiableSet(points);
    }

    public void insert(T point) {

        top = top.insert(point);
    }


    public class PointIterator extends Object implements Iterator<T>, Runnable, Visitor<T>  {

        private final Set<T> points = new LinkedHashSet<>();
        private final Iterator<T> currentIterator;

        public PointIterator() {

            top.accept(this);
            currentIterator = points.iterator();
        }


        @Override
        public void visit(LeafTrie<T> leaf) {
            leaf.collectAll(points);
        }

        @Override
        public void visit(NodeTrie<T> node) {

        }

        @Override
        public boolean hasNext() {
            return currentIterator.hasNext();
        }

        @Override
        public T next() {
            return currentIterator.next();
        }

        @Override
        public void run() {

        }
    }
}
