package sort.insertionSort;

import sort.Sortable;

/**
 * 插入排序，O(n^2)算法,可提前终止循环,对于近乎有序的数组效率特别高
 *
 * @Author liyong.liu
 * @Date 2019-06-03
 **/
public class InsertionSort<E extends Comparable<E>> implements Sortable<E> {

    @Override
    public E[] sort(E[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("arr is null");
        }
        for (int i = 0; i < arr.length; i++) {
            E e = arr[i];
            int j = i;
            for (; j > 0 && e.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = e;
        }
        return arr;
    }

    public static <E extends Comparable<E>> void insertionSort(E[] arr, int l, int r) {
        if (arr == null || arr.length == 0 || arr.length < r) {
            throw new IllegalArgumentException("arr is illegal");
        }
        for (int i = l; i <= r; i++) {
            E e = arr[i];
            int j = i;
            for (; j > 0 && e.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = e;
        }
    }

    private void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
