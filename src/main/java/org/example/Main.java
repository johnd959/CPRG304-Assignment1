package org.example;

import java.lang.reflect.Method;
import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws NoSuchMethodException {

        // initial argument length validation
        if (args.length != 3) throw new IllegalArgumentException("Please enter three arguments");

        //getting the arguments
        Dictionary<String, String> params = validateArgs(args);
        if (params.size() != 3) throw new IllegalArgumentException("Please enter three valid arguments");

        Enumeration<String> e = params.keys();
        while(e.hasMoreElements())
        {
            String key = e.nextElement();
            System.out.println(params.get(key));
        }

        //getting shapes from file
        FileReader fileReader = new FileReader(params.get("filePath"));
        Shape[] shapesArr = fileReader.getContent();

        //getting the shape comparator
        shapeComparator comparator = new shapeComparator(params.get("sortQuality").toCharArray()[0]);

        //invoking the utility methods and sorting
        sort(params.get("sortAlgorithm"), shapesArr, comparator);

        String selectedSortQuality = "getHeight";
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
            Method m = shapesArr.getClass().getMethod(selectedSortQuality);

            if (i % 1000 == 0)
            {
                System.out.println(m.invoke(),i);
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
    public static void sort(String algorithm, Object[] arr, Comparator comparator)
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
        }
    }
}