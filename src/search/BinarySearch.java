package search;

/**
 * @Author liyong.liu
 * @Date 2019-06-05
 **/
public class BinarySearch<E extends Comparable<E>> implements Searable<E> {
    @Override
    public int search(E[] arr, E target) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid].compareTo(target) > 0) {
                r = mid - 1;
            } else if (arr[mid].compareTo(target) < 0) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
        //递归方式的性能稍差一点
//        return search(arr, target, 0, arr.length - 1);
    }

    private int search(E[] arr, E target, int l, int r) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid].compareTo(target) > 0) {
                return search(arr, target, l, mid - 1);
            } else if (arr[mid].compareTo(target) < 0) {
                return search(arr, target, mid + 1, r);
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] arr = {-1, 1, 3, 5, 6, 8, 9, 11, 13};
        BinarySearch<Integer> bs = new BinarySearch<>();
        System.out.println(bs.search(arr, 1));
    }
}
