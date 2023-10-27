package org.example;

import org.example.shapes.Shape;
import org.example.shapes.ShapeComparator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        // initial argument length validation
        if (args.length != 3) throw new IllegalArgumentException("Please enter three arguments");

        //getting the arguments
        Dictionary<String, String> params = validateArgs(args);
        if (params.size() != 3) throw new IllegalArgumentException("Please enter three valid arguments");

        Enumeration<String> e = params.keys();
        while(e.hasMoreElements())
        {
            String key = e.nextElement();
            System.out.println(key + ": " + params.get(key));
        }

        //getting shapes from file
        FileReader fileReader = new FileReader(params.get("filePath"));
        Shape[] shapesArr = fileReader.getContent();

        //getting the shape comparator
        ShapeComparator comparator = new ShapeComparator(params.get("sortQuality").toCharArray()[0]);


        //getting sysTime before sorting
        double startTime = System.currentTimeMillis();

        try
        {
            //invoking the utility methods and sorting
            Sort(params.get("sortAlgorithm"), shapesArr, comparator);
        }
        catch (IllegalArgumentException exception)
        {
            System.out.println(exception.getMessage());
            return;
        }

        //getting the sysTime after sorting
        double endTime = System.currentTimeMillis();

        System.out.println("Sort duration: " + (endTime - startTime) + "ms");


        String selectedSortQuality = null;
        switch(params.get("sortQuality"))
        {
            case "h":
            {
                selectedSortQuality = "getHeight";
                break;
            }
            case "a":
            {
                selectedSortQuality = "calculateBaseArea";
                break;
            }
            case "v":
            {
                selectedSortQuality = "calculateVolume";
                break;
            }

        }

        for(int i = 0; i < shapesArr.length; i++)
        {
            Method m = shapesArr[i].getClass().getMethod(selectedSortQuality);

            if (i % 1000 == 0)
            {
                System.out.println(i + ": " + m.invoke(shapesArr[i]));
            }
        }


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
    public static void Sort(String algorithm, Object[] arr, Comparator comparator)
    {
        //instantiating sorter
        Sorter sorter = new Sorter(comparator);

        //selecting the right sorting algorithm
        switch(algorithm)
        {
            case "b":
            {
                //bubble sort
                sorter.Bubblesort(arr);
                break;
            }
            case "s":
            {
                //selection sort
                sorter.SelectionSort(arr);
                break;
            }
            case "i":
            {
                //insertion sort
                sorter.InsertionSort(arr);
                break;
            }
            case "m":
            {
                //merge sort
                sorter.MergeSort(arr);
                break;
            }
            case "q":
            {
                //quick sort
                sorter.Quicksort(arr, 0, arr.length - 1);
                break;
            }
            case "z":
            {
                //algorithm tbd sort
                sorter.HeapSort(arr);
                break;
            }
            default:
            {
                throw new IllegalArgumentException("Please choose a valid sorting algorithm\n" +
                        "Use option -sb for bubble sort\n" +
                        "Use option -si for insertion sort\n" +
                        "Use option -ss for selection sort\n" +
                        "Use option -sm for merge sort\n" +
                        "Use option -sq for quick sort\n" +
                        "Use option -sz for heap sort\n");
            }
        }
    }
}