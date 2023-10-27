package org.example.shapes;

//Cylinder class extending the Shape class
public class Cylinder extends Shape {
    private double height;
    private double radius;

    public Cylinder(double height, double radius){
        this.height = height;
        this.radius = radius;
    }

    @Override
    public double calculateVolume() {
        return Math.PI * height * radius * radius;
    }

    @Override
    public double calculateBaseArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getHeight() {
        return height;
    }

}
