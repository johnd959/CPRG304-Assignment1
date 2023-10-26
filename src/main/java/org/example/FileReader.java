package org.example;

import org.example.shapes.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class FileReader {

    //FileReader Fields
    public String filePath; // File path to read shapes from
    public Shape[] fileContent; //Array to store the Shapes


    //Constructor to initialize the file path
    public FileReader(String path){
        this.filePath = path;
    }
    //Method to get the array of shapes from the file
    public Shape[] getContent(){
        try {
            // Opening the file to read the data
            File shapesFile = new File(filePath);
            Scanner reader = new Scanner(shapesFile);

            while(reader.hasNextLine()){
                // Read data line by line from the file
                String data = reader.nextLine();
                String[] token = data.split(" ");
                fileContent = new Shape[Integer.parseInt(token[0])]; // Initializing the array of Shapes with the first number in the file
                int startIndex = 1;

                // iterating over the content of the file to create the shapes using createShape method
                for (int i = 0; i < fileContent.length ; i++){

                    fileContent[i] = createShape(token[startIndex], Double.parseDouble(token[startIndex + 1]), Double.parseDouble(token[startIndex + 2]));
                    startIndex += 3;

                }
            }
            reader.close();
            return fileContent;
        }
        // Handle the error if the path file is wrong
        catch (FileNotFoundException e){
            System.out.println(e.getMessage() + "\n Please use the option -f followed immediately by the file path (-fexample)");
            return new Shape[0];
        }
    }

    // Method to create a Shape instance using reflection
    private Shape createShape(String shapeType, double param1, double param2) {
        String className = "org.example.shapes." + shapeType;
        try {
            // Use reflection to create an instance of Shape using the given class name
            Class shapeClass = Class.forName(className);
            return (Shape) shapeClass.getConstructor(double.class, double.class).newInstance(param1, param2);
        }
        // Handle reflective operation exception
        catch (ReflectiveOperationException e) {
            System.out.println("Error creating shape");
            return null; // Handle unknown shape types appropriately
        }
    }

}
