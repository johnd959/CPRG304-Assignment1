package org.example.shapes;

////OctagonalPrism class extending the Shape class
public class OctagonalPrism extends Shape{
    private double height;
    private double edgeLength;

    public OctagonalPrism(double height, double edgeLength){
        this.height = height;
        this.edgeLength = edgeLength;
    }

    @Override
    public double calculateVolume(){
        return (1.0/2.0) * (1.0 + Math.sqrt(2)) * height * edgeLength * edgeLength;
    }

    @Override
    public double calculateBaseArea() {
        return (1.0 + Math.sqrt(2)) * edgeLength * edgeLength;
    }

    @Override
    public double getHeight(){
        return height;
    }
}
