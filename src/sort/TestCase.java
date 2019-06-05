package sort;

import org.junit.Test;
import sort.heapSort.HeapSort;
import sort.insertionSort.InsertionSort;
import sort.insertionSort.ShellSort;
import sort.mergeSort.MergeSort;
import sort.quickSort.QuickSort;
import sort.selectionSort.SelectionSort;

/**
 * @Author liyong.liu
 * @Date 2019-06-03
 **/
public class TestCase {
    @Test
    public void testSelectSort() {
        int n = 10000000;
        Integer[] randomArr = SortTestHelper.getRandomArr(n, Integer.MAX_VALUE);
        Integer[] nearlyOrderedArr = SortTestHelper.getApproximAateOrderedArr(n, 0.05);
        Integer[] manyDuplicateArr = SortTestHelper.getRandomArr(n, 10);
        Integer[] arrMin = {0, -1, 1, 3, 2, -2};

        SelectionSort<Integer> selectionSort = new SelectionSort<>();
        InsertionSort<Integer> insertionSort = new InsertionSort<>();
        ShellSort<Integer> shellSort = new ShellSort<>();
        MergeSort<Integer> mergeSort = new MergeSort<>();
        QuickSort<Integer> quickSort = new QuickSort<>();
        HeapSort<Integer> heapSort = new HeapSort<>();

//        SortTestHelper.testSort("SelectionSort", selectionSort, arr);
//        SortTestHelper.testSort("InsertionSort", insertionSort, arr);
//        SortTestHelper.testSort("ShellSort", shellSort, arr);
        SortTestHelper.testSort("MergeSort", mergeSort, manyDuplicateArr);
        SortTestHelper.testSort("QuickSort", quickSort, manyDuplicateArr);
        SortTestHelper.testSort("HeapSort", heapSort, manyDuplicateArr);
    }
}