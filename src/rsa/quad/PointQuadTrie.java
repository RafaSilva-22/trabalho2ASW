package rsa.quad;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class PointQuadTrie <T extends HasPoint> extends Object implements Iterable<T> {

    Trie<T> top;
    private final double topLeftX;
    private final double topLeftY;
    private final double bottomRightX;
    private final double bottomRightY;

    public PointQuadTrie(double topLeftX, double topLeftY, double bottomRightX, double bottomRightY){
        this.topLeftX = topLeftX;
        this.topLeftY = topLeftY;
        this.bottomRightX = bottomRightX;
        this.bottomRightY = bottomRightY;
    }

    @Override
    public Iterator<T> iterator() {
        return new PointIterator();
    }

    public Set<T> getAll(){
        Set<T> points = new LinkedHashSet<>();
        top.collectAll(points);
        return Collections.unmodifiableSet(points);
    }
    public void delete(T point){
        top.delete(point);
    }

    public void insert(T point){
        top.insert(point);
    }


    public class PointIterator extends Object implements Iterator<T>, Runnable, Visitor<T>  {

        @Override
        public void run() {

        }

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() {
            return null;
        }

        @Override
        public void visit(LeafTrie<T> leaf) {

        }

        @Override
        public void visit(NodeTrie<T> node) {

        }
    }
}
