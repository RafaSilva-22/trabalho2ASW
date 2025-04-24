package rsa.quad;

public class NodeTrie <T extends HasPoint>{
    private final double topLeftX;
    private final double topLeftY;
    private final double bottomRightX;
    private final double bottomRightY;
    public NodeTrie(double topLeftX, double topLeftY, double bottomRightX, double bottomRightY) {
        this.topLeftX = topLeftX;
        this.topLeftY = topLeftY;
        this.bottomRightX = bottomRightX;
        this.bottomRightY = bottomRightY;
    }

}
