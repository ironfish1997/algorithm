package sort;


import java.util.Random;

/**
 * @Author liyong.liu
 * @Date 2019-06-03
 **/
public class SortTestHelper {
    static <E extends Comparable<E>> void testSort(String sortName, Sortable<E> sorter, E[] arr) {
        E[] testArr = (E[]) new Comparable[arr.length];
        System.arraycopy(arr, 0, testArr, 0, arr.length);
        long startTime = System.nanoTime();
        testArr = sorter.sort(testArr);
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < testArr.length - 1; i++) {
            if (testArr[i].compareTo(testArr[i + 1]) > 0) {
                throw new IllegalArgumentException("测试失败！！！");
            }
            sb.append(testArr[i]).append(",");
        }
        sb.append(testArr[testArr.length - 1]).append("]");
//        System.out.println("测试成功: " + sb.toString());
        long endTime = System.nanoTime();
        System.out.println(sortName + ": " + (endTime - startTime) / 1000000000.0 + "s");
    }

    /**
     * 获得随机数组
     */
    static Integer[] getRandomArr(int capacity, int bound) {
        Integer[] arr = new Integer[capacity];
        Random random = new Random();
        for (int i = 0; i < capacity; i++) {
            arr[i] = random.nextInt(bound);
        }
        return arr;
    }

    /**
     * 获得近似有序的数组
     */
    static Integer[] getApproximAateOrderedArr(int capacity, double mixRate) {
        if (mixRate < 0 || mixRate > 1) {
            throw new IllegalArgumentException("mixRate is illegal");
        }
        Integer[] arr = new Integer[capacity];
        Random random = new Random();
        for (int i = 0; i < capacity; i++) {
            arr[i] = i;
        }
        //随机打乱30%的元素
        for (int i = 1; i < capacity * mixRate; i++) {
            int index = random.nextInt(capacity);
            arr[index] = arr[random.nextInt(capacity)];
        }
        return arr;
    }

    /**
     * 获得完全有序的数组
     */
    static Integer[] getCompletelyOrderedArr(int capacity) {
        Integer[] arr = new Integer[capacity];
        for (int i = 0; i < capacity; i++) {
            arr[i] = i;
        }
        return arr;
    }
}
