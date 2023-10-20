package org.example;

public abstract class shape implements Comparable {

    public int height;

    @Override
    public int compareTo(Object o) {
        return height - ((shape) o).height;
    }
}
