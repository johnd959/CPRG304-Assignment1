package org.example;

import org.example.shapes.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

    public String filePath;
    public Shape[] fileContent;


    public FileReader(String path){
        this.filePath = path;
    }

    public Shape[] getContent(){
        try {

            File shapesFile = new File(filePath);
            Scanner reader = new Scanner(shapesFile);

            while(reader.hasNextLine()){

                String data = reader.nextLine();
                String[] token = data.split(" ");
                fileContent = new Shape[Integer.parseInt(token[0])];
                int startIndex = 1;

                for (int i = 0; i < fileContent.length ; i++){

                    fileContent[i] = createShape(token[startIndex], Double.parseDouble(token[startIndex + 1]), Double.parseDouble(token[startIndex + 2]));
                    startIndex += 3;

                }
            }
            reader.close();
            return fileContent;
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage() + "\n Please use the option -f followed immediately by the file path (-fexample)");
            return new Shape[0];
        }
    }

    private Shape createShape(String shapeType, double param1, double param2) {
        switch (shapeType.toUpperCase()) {
            case "CONE":
                return new Cone(param1, param2);
            case "CYLINDER":
                return new Cylinder(param1, param2);
            case "PYRAMID":
                return new Pyramid(param1, param2);
            case "OCTAGONALPRISM":
                return new OctagonalPrism(param1, param2);
            case "PENTAGONALPRISM":
                return new PentagonalPrism(param1, param2);
            case "SQUAREPRISM":
                return new SquarePrism(param1, param2);
            case "TRIANGULARPRISM":
                return new TriangularPrism(param1, param2);
            default:
                return null; // Handle unknown shape types appropriately (throw an exception, return a default shape, etc.)
        }
    }

}
