package org.example;

import java.util.Comparator;
public abstract class Shape implements Comparable {

    public int height;


    public Shape(int height)
    {
        this.height = height;
    }
    @Override
    public int compareTo(Object o) {
        return height - ((Shape) o).height;
    }
}
