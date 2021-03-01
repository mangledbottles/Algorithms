// -------------------------------------------------------------------------

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
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
    // 65318724
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

        return a;
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
     *
     * Adds each double to an ArrayList and converts to double[] data structure at end
     * This method assumes the input length is unknown, hence a double[] cannot be established
     * unless you want to create a new double[i] with every time i increments (new line detected)
      */
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

}//end class

