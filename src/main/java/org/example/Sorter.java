package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Sorter<T> {


    private Comparator comparator;

    public Sorter(Comparator comparator)
    {
        this.comparator = comparator;
    }

    public void Bubblesort(T[] array){
        boolean isSorted;
        for(var i=0; i<array.length; i++){
            isSorted = true;
            for(var j = 1; j<array.length; j++)
                if(comparator.compare(array[j], array[j-1]) < 0){
                    swap(array,j,j-1);
                    isSorted = false;
                }
            if(isSorted)
                return;}
    }
    private void swap(T[] array, int index1, int index2){
        var temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public void InsertionSort(T[] array){
        for(var i=1; i<array.length;i++){
            var current = array[i];
            var j = i-1;
            while(j>=0 && (comparator.compare(array[j], current) > 0)){
                array[j+1] = array[j];
                j--;
            }
            array[j+1]=current;
        }
    }

    public void SelectionSort(T[] array){
        for(var i=0; i<array.length; i++){
            var minIndex = i;
            for(var j=i; j<array.length; j++)
                if (comparator.compare(array[j], array[minIndex]) < 0)
                    minIndex = j;
            swap(array,minIndex,i);

        }
    }

    public void MergeSort(T[] array){
        if(array.length<2)
            return;

        var middle = array.length/2;

        Object[] left = new Object[middle];
        for (var i=0; i<middle; i++)
            left[i] = array[i];

        Object[] right = new Object[array.length - middle];
        for (var i=middle;i< array.length; i++)
            right[i-middle] = array[i];

        MergeSort((T[]) left);
        MergeSort((T[]) right);

        merge((T[]) left,(T[]) right,array);
    }
    private void merge(T[] left, T[] right, T[] result){
        int i=0,j=0,k=0;
        while (i< left.length && j< right.length){
            if (comparator.compare(left[i], right[j]) <= 0)
                result[k++] = left[i++];
            else
                result[k++] = right[j++];
        }
        while (i < left.length)
            result[k++] = left[i++];
        while (j< right.length)
            result[k++] = right[j++];
    }

    public void Quicksort(T[] array,int start,int end){
        if (start >= end)
            return;
        var boundary = partition(array,start,end);

        Quicksort(array,start,boundary-1);
        Quicksort(array,boundary+1,end);
    }

    private int partition (T[] array,int start,int end){
        var pivot = array[end];
        var boundary = start-1;
        for(var i=start; i<=end ;i++)
            if (comparator.compare(array[i], pivot) <= 0){
                swap(array,i,++boundary);
            }
        return boundary;
    }

    public void HeapSort(T[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n - 1; i > 0; i--) {
            T temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    private void heapify(T[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && comparator.compare(arr[left], arr[largest]) > 0)
            largest = left;

        if (right < n && comparator.compare(arr[right], arr[largest]) > 0)
            largest = right;

        if (largest != i) {
            T swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }
}
