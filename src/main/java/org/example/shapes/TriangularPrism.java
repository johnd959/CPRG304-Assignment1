package org.example.shapes;

////TriangularPrism class extending the Shape class
public class TriangularPrism extends Shape{
    private double height;
    private double edgeLength;

    public TriangularPrism(double height, double edgeLength){
        this.height = height;
        this.edgeLength = edgeLength;
    }

    @Override
    public double calculateVolume(){
        return (1.0/2.0) * height * edgeLength * edgeLength;
    }
    @Override
    public double calculateBaseArea(){
        return (Math.sqrt(3) / 4) * edgeLength * edgeLength;
    }

    @Override
    public double getHeight(){
        return height;
    }
}
