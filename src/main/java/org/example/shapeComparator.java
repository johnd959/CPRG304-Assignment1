package org.example;

import java.util.Comparator;

public class shapeComparator implements Comparator<Shape>{
    private char compareType;

    public shapeComparator(char compareType) {
        this.compareType = compareType;
    }

    @Override
    public int compare(Shape shape1, Shape shape2) {
        switch (compareType) {
            case 'h':
                return shape1.compareTo(shape2);
            case 'v':
                return Shape.volumeComparator.compare(shape1, shape2);
            case 'a':
                return Shape.baseAreaComparator.compare(shape1, shape2);
            default:
                throw new IllegalArgumentException(compareType + " is not a valid input. Please try again.");
        }
    }
}


