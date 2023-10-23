package org.example;

public abstract class Shape implements Comparable {

    public int height;

    @Override
    public int compareTo(Object o) {
        return height - ((Shape) o).height;
    }
}
