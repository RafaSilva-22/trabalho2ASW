package rsa.match;

import rsa.quad.HasPoint;

public record Location(double x, double y) implements HasPoint {



    public double x() {
        return x;
    }
    public double y() {
        return y;
    }

    public int hashCode() {
        return (int) (x * 31 + y);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        return o != null && getClass() == o.getClass();
    }

}
