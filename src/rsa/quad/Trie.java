package rsa.quad;

public class Trie <T extends HasPoint> {
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




}
