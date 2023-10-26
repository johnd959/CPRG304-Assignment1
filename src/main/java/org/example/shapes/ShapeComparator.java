package org.example.shapes;

import java.util.Comparator;

public class ShapeComparator implements Comparator<Shape>{
    private char compareType;

    public char getCompareType() {
        return compareType;
    }

    public ShapeComparator(char compareType) {
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
                throw new IllegalArgumentException(compareType + " is not a valid input. Please try again.\n" +
                        "Use option -th for sorting by height\n" +
                        "Use option -ta for sorting by the base area\n" +
                        "Use option -tv for sorting by the volume");
        }
    }
}


