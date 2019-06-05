package sort.insertionSort;

import sort.Sortable;

/**
 * @Author liyong.liu
 * @Date 2019-06-03
 **/
public class ShellSort<E extends Comparable<E>> implements Sortable<E> {
    @Override
    public E[] sort(E[] arr) {
        for (int start = arr.length / 2; start > 0; start /= 2) {
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for (int i = start; i < arr.length; i++) {
                E element = arr[i];
                int j = i;
                if (arr[j].compareTo(arr[j - start]) < 0) {
                    while (j - start >= 0 && element.compareTo(arr[j - start]) < 0) {
                        arr[j] = arr[j - start];
                        j -= start;
                    }
                }
                arr[j] = element;
            }
        }
        return arr;
    }
}
