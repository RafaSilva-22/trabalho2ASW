package rsa.quad;

public interface Visitor <T extends HasPoint> {
    void visit(LeafTrie<T> leaf);
    void visit(NodeTrie<T> node);
}
