package sort.mergeSort;

import sort.Sortable;

import static java.lang.Math.min;

/**
 * @Author liyong.liu
 * @Date 2019-06-03
 **/
public class MergeSort<E extends Comparable<E>> implements Sortable<E> {
    @Override
    public E[] sort(E[] arr) {
        mergeSort(arr, 0, arr.length - 1);
        return arr;
    }

    private void mergeSort(E[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private void merge(E[] arr, int l, int mid, int r) {
        E[] temp = (E[]) new Comparable[r - l + 1];
        if (r + 1 - l >= 0) System.arraycopy(arr, l, temp, 0, r + 1 - l);
        int pl = l, pr = mid + 1;
        for (int k = pl; k <= r; k++) {
            if (pl > mid) {
                arr[k] = temp[pr - l];
                pr++;
            } else if (pr > r) {
                arr[k] = temp[pl - l];
                pl++;
            } else if (temp[pl - l].compareTo(temp[pr - l]) < 0) {
                arr[k] = temp[pl - l];
                pl++;
            } else {
                arr[k] = temp[pr - l];
                pr++;
            }
        }
    }

    /**
     * 自底向上归并
     */
    public void mergeSortBu(E[] arr) {
        for (int sz = 1; sz <= arr.length; sz += sz) {
            for (int i = 0; i < arr.length; i += sz + sz) {
                //对 arr[i...i+sz-1] 和 arr[i+sz...i+2*sz-1]进行归并
                merge(arr, i, i + sz - 1, min(i + sz + sz - 1, arr.length - 1));
            }
        }
    }
}
