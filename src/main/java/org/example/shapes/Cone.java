package org.example.shapes;

//Cone class extending the Shape class
public class Cone extends Shape {
    private double height;
    private double radius;

    public Cone(double height, double radius){
        this.height = height;
        this.radius = radius;
    }

    @Override
    public double calculateVolume(){
        return (1.0/3.0) * Math.PI * height * radius * radius;
    }

    @Override
    public double calculateBaseArea(){
        return Math.PI * radius * radius;
    }

    @Override
    public double getHeight(){
        return height;
    }
}
