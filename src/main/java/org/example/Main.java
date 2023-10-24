package org.example;

import java.util.Arrays;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        // initial argument length validation
        if (args.length != 3) throw new IllegalArgumentException("Please enter three arguments");

        //getting the arguments
        Dictionary<String, String> params = validateArgs(args);
        if (params.size() != 3) throw new IllegalArgumentException("Please enter three valid arguments");

        //getting shapes from file
        FileReader fileReader = new FileReader("temp.txt");
        Shape[] shapesArr = fileReader.getContent();

        Enumeration<String> e = params.keys();
        System.out.println(Arrays.toString(args));
        while(e.hasMoreElements())
        {
            String key = e.nextElement();
            System.out.println(params.get(key));
        }

        //sort(params.get("sortAlgorithm", shapesArr));

    }

    /**
     *
     * @param args
     * @return
     * Dictionary<String, String>
     * Takes in the command line arguments provided at run time and extracts the run-time parameters
     * of the sorting program. The sorting algorithm, quality to sort by, and the path to file wherein
     * the shapes are stored are retrieved and returned as a Dictionary (Hashtable) of strings
     */
    public static Dictionary<String, String> validateArgs(String[] args)
    {
        Dictionary<String, String> arguments = new Hashtable<>();

        for(int i = 0; i < args.length; i++)
        {
            String content = args[i].substring(2, args[i].length());
            if(args[i].substring(0, 2).contains("-t")) {
                arguments.put("sortQuality", content);
            }
            else if(args[i].substring(0,2).contains("-s"))
            {
                arguments.put("sortAlgorithm", content);
            }
            else if(args[i].substring(0,2).contains("-f"))
            {
                arguments.put("filePath", content);
            }
        }

        return arguments;
    }

    //signature for future sort selection

    /**
     *
     * @param algorithm
     * @param arr
     *
     * Takes in a string to select the sorting algorithm that will be applied on array arr.
     */
    public static void sort(String algorithm, Object[] arr)
    {
        //selecting the right sorting algorithm
        switch(algorithm)
        {
            case "b":
            {
                //bubble sort
                break;
            }
            case "s":
            {
                //selection sort
                break;
            }
            case "i":
            {
                //insertion sort
                break;
            }
            case "m":
            {
                //merge sort
                break;
            }
            case "q":
            {
                //quick sort
                break;
            }
            case "z":
            {
                //algorithm tbd sort
                break;
            }
        }
    }
}