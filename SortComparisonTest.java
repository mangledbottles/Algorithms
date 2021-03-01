import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author
 *  @version HT 2020
 */
@RunWith(JUnit4.class)
public class SortComparisonTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new SortComparison();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     */
    @Test
    public void testEmpty()
    {
    }


    // TODO: add more tests here. Each line of code and ech decision in Collinear.java should
    // be executed at least once from at least one test.

    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
    @Test
    public void main()
    {
//        new SortComparison();
        SortComparison.main();
        //TODO: implement this method

    }


    @Test
    public void testInsertionSort() {
        double[] input = new double[]{6, 5, 3, 1, 8, 7, 2, 4};
        assertEquals("[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0]", Arrays.toString(SortComparison.insertionSort(input)));

    }

    @Test
    public void testSelectionSort() {
        double[] input = new double[]{6, 5, 3, 1, 8, 7, 2, 4};
        assertEquals("[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0]", Arrays.toString(SortComparison.selectionSort(input)));

    }

    @Test
    public void testQuickSort() {
        double[] input = new double[]{6, 5, 3, 1, 8, 7, 2, 4};
        assertEquals("[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0]", Arrays.toString(SortComparison.quickSort(input)));

    }


}

