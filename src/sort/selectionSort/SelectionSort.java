package sort.selectionSort;

import sort.Sortable;

/**
 * 选择排序, O(n^2)
 *
 * @Author liyong.liu
 * @Date 2019-06-03
 **/
public class SelectionSort<E extends Comparable<E>> implements Sortable<E> {

    @Override
    public E[] sort(E[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("arr is null");
        }
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(arr, minIndex, i);
            }
        }
        return arr;
    }

    private void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
