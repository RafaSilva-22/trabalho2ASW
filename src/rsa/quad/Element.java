package rsa.quad;

public interface Element <T extends HasPoint>{
    void accept(Visitor<T> visitor);
}
