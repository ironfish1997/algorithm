package sort.heapSort;

import sort.Sortable;

/**
 * @Author liyong.liu
 * @Date 2019-06-05
 **/
public class HeapSort<E extends Comparable<E>> implements Sortable<E> {

    @Override
    public E[] sort(E[] arr) {
        int n = arr.length;
        for (int i = (n - 1) / 2; i >= 0; i--) {
            siftDown(arr, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            swap(arr, 0, i);
            siftDown(arr, i, 0);
        }
        return arr;
    }

    private void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void siftDown(E[] arr, int n, int i) {
        while (2 * i + 1 < n) {
            int leftChild = 2 * i + 1;
            int rightChild = leftChild + 1;
            int index = leftChild;
            if (rightChild < n && arr[leftChild].compareTo(arr[rightChild]) < 0) {
                index = rightChild;
            }
            if (arr[index].compareTo(arr[i]) <= 0) {
                break;
            }
            swap(arr, index, i);
            i = index;
        }
    }
}
