package org.example;

import java.util.Comparator;
public abstract class Shape implements Comparable<Shape> {

    public abstract double calculateVolume();

    public abstract double calculateBaseArea();

    public abstract double getHeight();

    @Override
    public int compareTo(Shape other) {
        return Double.compare(this.getHeight(), other.getHeight());
    }

    public static Comparator<Shape> baseAreaComparator = Comparator.comparingDouble(Shape::calculateBaseArea);

    public static Comparator<Shape> volumeComparator = Comparator.comparingDouble(Shape::calculateVolume);
}
