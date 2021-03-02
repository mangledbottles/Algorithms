import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author
 *  @version HT 2020
 *
 *  TODO: Test empty input, algorithm performance comparison
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
        // Test normal unsorted array
        double[] input = new double[]{6, 5, 3, 1, 8, 7, 2, 4};
        assertEquals("[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0]", Arrays.toString(SortComparison.insertionSort(input)));

        // Test sorted array
        input = new double[]{ 1, 2, 3, 4, 5};
        assertEquals("[1.0, 2.0, 3.0, 4.0, 5.0]", Arrays.toString(SortComparison.insertionSort(input)));
        
        // Test empty
        input = new double[0];
        assertEquals("[]", Arrays.toString(SortComparison.insertionSort((input))));
    }

    @Test
    public void testSelectionSort() {
        // Test normal unsorted array
        double[] input = new double[]{6, 5, 3, 1, 8, 7, 2, 4};
        assertEquals("[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0]", Arrays.toString(SortComparison.selectionSort(input)));

        // Test sorted array
        input = new double[]{ 1, 2, 3, 4, 5};
        assertEquals("[1.0, 2.0, 3.0, 4.0, 5.0]", Arrays.toString(SortComparison.selectionSort(input)));

        // Test empty
        input = new double[0];
        assertEquals("[]", Arrays.toString(SortComparison.selectionSort((input))));
    }

    @Test
    public void testQuickSort() {
        // Test normal unsorted array
        double[] input = new double[]{6, 5, 3, 1, 8, 7, 2, 4};
        assertEquals("[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0]", Arrays.toString(SortComparison.quickSort(input)));

        // Test sorted array
        input = new double[]{ 1, 2, 3, 4, 5};
        assertEquals("[1.0, 2.0, 3.0, 4.0, 5.0]", Arrays.toString(SortComparison.quickSort(input)));

        // Test empty
        input = new double[0];
        assertEquals("[]", Arrays.toString(SortComparison.quickSort((input))));
    }

    @Test
    public void testMergeSort() {
        // Test normal unsorted array
        double[] input = new double[]{6, 5, 3, 1, 8, 7, 2, 4};
        assertEquals("[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0]", Arrays.toString(SortComparison.mergeSort(input)));

        // Test sorted array
        input = new double[]{ 1, 2, 3, 4, 5};
        assertEquals("[1.0, 2.0, 3.0, 4.0, 5.0]", Arrays.toString(SortComparison.mergeSort(input)));

        // Test empty
        input = new double[0];
        assertEquals("[]", Arrays.toString(SortComparison.mergeSort((input))));
    }


}

