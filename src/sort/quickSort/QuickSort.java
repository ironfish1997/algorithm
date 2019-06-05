package sort.quickSort;

import sort.Sortable;
import sort.insertionSort.InsertionSort;

import java.util.Random;


/**
 * @Author liyong.liu
 * @Date 2019-06-04
 **/
public class QuickSort<E extends Comparable<E>> implements Sortable<E> {
    private static Random random = new Random();

    @Override
    public E[] sort(E[] arr) {
        quickSortThreeWays(arr, 0, arr.length - 1);
        return arr;
    }

    private void quickSort(E[] arr, int l, int r) {
//        if (l >= r) {
//            return;
//        }
        //优化，当数组很小近乎有序，用插入排序
        if (r - l <= 15) {
            InsertionSort.insertionSort(arr, l, r);
            return;
        }
//        int p = partition(arr, l, r);
        //这里使用双路快排
        int p = partitionTwoWay(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }

    private void quickSortThreeWays(E[] arr, int l, int r) {
//        if (l >= r) {
//            return;
//        }
        //优化，当数组很小近乎有序，用插入排序
        if (r - l <= 15) {
            InsertionSort.insertionSort(arr, l, r);
            return;
        }
        //这里使用三路快排
        int[] ltAndGt = partitionThreeWay(arr, l, r);
        quickSort(arr, l, ltAndGt[0]);
        quickSort(arr, ltAndGt[1], r);
    }

    private int partition(E[] arr, int l, int r) {
        //为了避免近似有序数组的时间复杂度降低到O(n^2),故将需要分区的数组第一个元素随机调换位置==>O(nlogn）
        swap(arr, l, random.nextInt(r - l + 1) + l);
        E element = arr[l];
        int j = l, i = l + 1;
        for (; i <= r; i++) {
            if (element.compareTo(arr[i]) > 0) {
                swap(arr, ++j, i);
            }
        }
        swap(arr, j, l);
        return j;
    }

    //双路快排
    private int partitionTwoWay(E[] arr, int l, int r) {
        //为了避免近似有序数组的时间复杂度降低到O(n^2),故将需要分区的数组第一个元素随机调换位置==>O(nlogn）
        swap(arr, l, random.nextInt(r - l + 1) + l);
        E element = arr[l];
        int i = l + 1, j = r;
        while (true) {
            while (i <= r && element.compareTo(arr[i]) > 0) i++;
            while (j >= l + 1 && element.compareTo(arr[j]) < 0) j--;
            if (i > j) break;
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, j, l);
        return j;
    }

    //三路快排，范围是arr[l....r], arr[l+1, lt]< element, arr[gt...r]>element;
    private int[] partitionThreeWay(E[] arr, int l, int r) {
        //为了避免近似有序数组的时间复杂度降低到O(n^2),故将需要分区的数组第一个元素随机调换位置==>O(nlogn）
        swap(arr, l, random.nextInt(r - l + 1) + l);
        E element = arr[l];
        int lt = l, gt = r, i = l + 1;
        while (i < gt) {
            if (element.compareTo(arr[i]) > 0) {
                swap(arr, i++, ++lt);
            } else if (element.compareTo(arr[i]) < 0) {
                swap(arr, i, --gt);
            } else {
                i++;
            }
        }
        swap(arr, l, lt);
        return new int[]{lt - 1, gt};
    }


    private void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
