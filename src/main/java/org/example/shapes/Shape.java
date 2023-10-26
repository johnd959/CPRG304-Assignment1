package org.example.shapes;

import java.util.Comparator;

//Abstract class for the three-dimensional shapes
public abstract class Shape implements Comparable<Shape> {

    //Abstract method to calculate the volume of the shape
    public abstract double calculateVolume();

    //abstract method to calculate the base area of the shape
    public abstract double calculateBaseArea();

    //Abstract method to get the height of the shape
    public abstract double getHeight();

    //Implementation of the compareTo method to compare the shapes by their height
    @Override
    public int compareTo(Shape other) {
        return Double.compare(this.getHeight(), other.getHeight());
    }

    //Implementing comparator to compare the shapes by their base area
    public static Comparator<Shape> baseAreaComparator = Comparator.comparingDouble(Shape::calculateBaseArea);

    //Implementing comparator to compare the shapes by their volume
    public static Comparator<Shape> volumeComparator = Comparator.comparingDouble(Shape::calculateVolume);
}
