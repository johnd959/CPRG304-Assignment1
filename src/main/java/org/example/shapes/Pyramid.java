package org.example.shapes;

//Pyramid class extending the Shape class
public class Pyramid  extends Shape{
    private double height;
    private double edgeLength;

    public Pyramid(double height, double edgeLength){
        this.height = height;
        this.edgeLength = edgeLength;
    }

    @Override
    public double calculateVolume(){
        return (1.0/3.0) * height * edgeLength * edgeLength;
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
