package org.example;

<<<<<<< HEAD:src/main/java/org/example/shape.java
import java.util.Comparator;

public abstract class shape implements Comparable {
=======
public abstract class Shape implements Comparable {
>>>>>>> Ahmad:src/main/java/org/example/Shape.java

    public int height;


    public shape(int height)
    {
        this.height = height;
    }
    @Override
    public int compareTo(Object o) {
        return height - ((Shape) o).height;
    }
}
