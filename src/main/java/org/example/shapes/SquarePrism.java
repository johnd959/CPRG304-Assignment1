package org.example.shapes;

public class SquarePrism extends Shape{
    private double height;
    private double edgeLength;

    public SquarePrism(double height, double edgeLength) {
        this.height = height;
        this.edgeLength = edgeLength;
    }

    @Override
    public double calculateVolume(){
        return height * edgeLength * edgeLength;
    }

    @Override
    public double calculateBaseArea(){
        return edgeLength * edgeLength;
    }

    @Override
    public double getHeight(){
        return height;
    }
}
