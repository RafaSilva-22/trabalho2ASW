package rsa.quad;

public class LeafTrie <T extends HasPoint>{
    private final double topLeftX;
    private final double topLeftY;
    private final double topRightX;
    private final double topRightY;

    LeafTrie(double topLeftX, double topLeftY, double bottomRightX, double bottomRightY){
        this.topLeftX = topLeftX;
        this.topLeftY = topLeftY;
        this.topRightX = bottomRightX;
        this.topRightY = bottomRightY;
    }
}
