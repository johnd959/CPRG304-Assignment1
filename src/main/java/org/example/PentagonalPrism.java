package org.example;

public class PentagonalPrism extends Shape{
    private double height;
    private double edgeLength;

    public PentagonalPrism(double height, double edgeLength){
        this.height = height;
        this.edgeLength = edgeLength;
    }

    @Override
    public double calculateVolume() {
        return (5.0/4.0) * Math.tan(Math.toRadians(54)) * height * edgeLength * edgeLength;
    }

    @Override
    public double calculateBaseArea(){
        return (5.0/4.0) * Math.tan(Math.toRadians(54)) * edgeLength * edgeLength;
    }

    public double getHeight(){
        return height;
    }
}
