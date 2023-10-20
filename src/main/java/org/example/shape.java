package org.example;

import java.util.Comparator;

public abstract class shape implements Comparable {

    public int height;


    public shape(int height)
    {
        this.height = height;
    }
    @Override
    public int compareTo(Object o) {
        return height - ((shape) o).height;
    }
}
