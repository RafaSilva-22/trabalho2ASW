package rsa.ride;

import rsa.match.RideMatch;

import java.util.Comparator;

public interface RideMatchSorter {
    Comparator<RideMatch> getComparator();
}
