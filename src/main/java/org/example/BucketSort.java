import java.util.ArrayList;
import java.util.*;

public class BucketSort {
    public static void sort(double[] array, int numberOfBuket) {
        if (numberOfBuket <= 0) throw new IllegalArgumentException("Invalid bucket count");

        // Determine minimum and maximum values
        double minValue = array[0];
        double maxValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minValue) minValue = array[i];
            else if (array[i] > maxValue) maxValue = array[i];
        }

        // Initialize buckets
        double interval = ((double)(maxValue - minValue + 1))/numberOfBuket;
        ArrayList<ArrayList<Double>> buckets = new ArrayList<ArrayList<Double>>(numberOfBuket);
        for (int i = 0; i < numberOfBuket; i++) {
            buckets.add(new ArrayList<Double>());
        }

        // Distribute input data into buckets
        for (int i = 0; i < array.length; i++) {
            buckets.get((int)((array[i] - minValue) / interval)).add(array[i]);
        }

        // Sort buckets and merge them to get sorted array
        int pointer = 0;
        for (int i = 0; i < buckets.size(); i++) {
            Collections.sort(buckets.get(i));
            for (int j = 0; j < buckets.get(i).size(); j++) {
                array[pointer] = buckets.get(i).get(j);
                pointer++;
            }
        }
    }


}
