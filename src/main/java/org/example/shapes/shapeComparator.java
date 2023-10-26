package org.example.shapes;

import java.util.Comparator;

//shapeComparator class to compare the shapes based on the user input i.e. height, volume or base area
public class shapeComparator implements Comparator<Shape>{
    private char compareType;

    public char getCompareType() {
        return compareType;
    }

    public shapeComparator(char compareType) {
        this.compareType = compareType;
    }

    @Override
    public int compare(Shape shape1, Shape shape2) {
        switch (compareType) {
            //compare by height
            case 'h':
                return shape1.compareTo(shape2);
            //compare by volume
            case 'v':
                return Shape.volumeComparator.compare(shape1, shape2);
            //compare by base area
            case 'a':
                return Shape.baseAreaComparator.compare(shape1, shape2);
            //throwing exception in case of wrong user input
            default:
                throw new IllegalArgumentException(compareType + " is not a valid input. Please try again.");
        }
    }
}


