public class Mergesort {
    public void  sort(double[] array){
        if(array.length<2)
            return;

        var middle = array.length/2;

        double[] left = new double[middle];
        for (var i=0; i<middle; i++)
            left[i] = array[i];

        double[] right = new double[array.length-middle];
        for (var i=middle;i< array.length; i++)
            right[i-middle] = array[i];
        sort(left);
        sort(right);

        merge(left,right,array);
    }
    private void merge(double[] left, double[] right, double[] result){
        int i=0,j=0,k=0;
        while (i< left.length && j< right.length){
            if (left[i]<=right[j])
                result[k++] = left[i++];
            else
                result[k++] = right[j++];
        }
        while (i < left.length)
            result[k++] = left[i++];
        while (j<right.length)
            result[k++] = right[j++];
    }
}
