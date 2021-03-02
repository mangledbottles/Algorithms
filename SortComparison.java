import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author Dermot O'Brien
 *  @version HT 2020
 */

 class SortComparison {

    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     *
     */
    static double [] insertionSort (double a[]){
        for(int i=1; i<a.length; i++) {
            for(int j=i; j>0; j--) {
                if (a[j-1] > a[j]) {
                    swap(a, j, j-1);
                }
            }
        }
        return a;
    }

    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] selectionSort (double a[]){
        for(int i=0; i<=a.length; i++) {
            int smallest = i;
            for(int j=i+1; j<a.length; j++) {
                if(a[j] < a[smallest]) {
                    smallest = j;
                }
            }
            if(smallest != i) {
                swap(a, i, smallest);
            }
        }
        return a;
    }

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double[] quickSort (double a[]){
        quickSortRecursive(a, 0, a.length-1);
        return a;
    }

    static void quickSortRecursive(double[] array, int min, int max) {
        if(max <= min) return;
        int pivotLocation = quickSortPartition(array, min, max);
        quickSortRecursive(array, min, pivotLocation-1);
        quickSortRecursive(array, pivotLocation+1, max);
    }

    static int quickSortPartition(double[] array, int low, int high) {
        double pivot = array[high];
        int i = (low-1);
        for(int j=low; j<high; j++) {
            if(array[j] <= pivot) {
                swap(array, ++i, j);
            }
        }
        swap(array, i+1, high);
        return i+1;
    }

    /**
     * Swap two doubles in a double[] array
     * @param array
     * @param a
     * @param b
     */
    static void swap(double[] array, int a, int b) {
        double tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    /**
     * Sorts an array of doubles using Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    /**
     * Sorts an array of doubles using iterative implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */

    static double[] mergeSort (double a[]) {
        mergeSortRecursive(a, 0, a.length-1);
        return a;
    }

    /**
     * Top down merge sort
     * Divides the array (double a[] into 2 halves and sort each recursively and finally merge them
     *
     * @param a the array (double[])
     * @param l left half
     * @param r right half
     */

    static void mergeSortRecursive(double a[], int l, int r) {
        if(l < r) {
            int mid = (l + r) /2;
            mergeSortRecursive(a, l, mid); // sort first half
            mergeSortRecursive(a, mid + 1, r); // sort second half

            mergeHalves(a, l, mid, r); // merge both sorted halves
        }
    }

    /**
     * Merge sorted halves for merge sort
     * @param arr the array
     * @param l left half
     * @param mid middle element index
     * @param r right half
     */

    static void mergeHalves(double arr[], int l, int mid, int r) {
        // Find sizes of two subarrays to be merged
        int subArr1 = mid - l + 1;
        int subArr2 = r - mid;

        /* Create temp arrays */
        double leftTmp[] = new double[subArr1];
        double rightTmp[] = new double[subArr2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < subArr1; ++i) leftTmp[i] = arr[l + i];

        for (int j = 0; j < subArr2; ++j) rightTmp[j] = arr[mid + 1 + j];


        int i = 0, j = 0;

        int k = l;
        while (i < subArr1 && j < subArr2) {
            if (leftTmp[i] <= rightTmp[j]) {
                arr[k] = leftTmp[i];
                i++;
            }
            else {
                arr[k] = rightTmp[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftTmp[] (if any)
        while (i < subArr1) {
            arr[k] = leftTmp[i];
            i++;
            k++;
        }
        // Copy remaining elements of rightTmp[] (if any)
        while (j < subArr2) {
            arr[k] = rightTmp[j];
            j++;
            k++;
        }
    }

    public static void main() {

        //todo: do experiments as per assignment instructions

//        double[] numbers1k = readFile("numbers1000.txt", 1000);
//        System.out.println(Arrays.toString(numbers1k));

//        double[] numbers10k = readFile("numbers10000.txt", 10000);
//        System.out.println(Arrays.toString(numbers10k));

//        System.out.println(numbers1000);
    }

    /**
     * Reads file and converts to double[]
     *
     * @param fileName name of file
     * @param size size of expected quantity of doubles
     * @return doubles in single double[]
     */
    public static double[] readFile(String fileName, int size) {
        File myObj = new File(fileName);
        double[] result = new double[size];
        int count = 0;
        try {
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextDouble()) {
                Double data = myReader.nextDouble();
                result[count++] = data;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Alternative readFile method
     * This method is NOT used
     * WebCat does not like ArrayList :)
     *
     * Adds each double to an ArrayList and converts to double[] data structure at end
     * This method assumes the input length is unknown, hence a double[] cannot be established
     * unless you want to create a new double[i] with every time i increments (new line detected)

    public static double[] readFile(String fileName) {
        File myObj = new File(fileName);
        ArrayList<Double> result = new ArrayList();
        try {
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextDouble()) {
                Double data = myReader.nextDouble();
                result.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result.stream().mapToDouble(Double::doubleValue).toArray();
    }
     */

}//end class

