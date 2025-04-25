package rsa.quad;

import java.util.HashMap;
import java.util.Map;

public class NodeTrie <T extends HasPoint>{
    private final double topLeftX;
    private final double topLeftY;
    private final double bottomRightX;
    private final double bottomRightY;

    final Map<Trie.Quadrant,Trie<T>> tries;

    public NodeTrie(double topLeftX, double topLeftY, double bottomRightX, double bottomRightY) {
        this.topLeftX = topLeftX;
        this.topLeftY = topLeftY;
        this.bottomRightX = bottomRightX;
        this.bottomRightY = bottomRightY;
        tries = new HashMap<>();
    }

}
