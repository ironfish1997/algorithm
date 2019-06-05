package sort;

/**
 * @Author liyong.liu
 * @Date 2019-06-03
 **/
public interface Sortable<E extends Comparable<E>> {
    E[] sort(E[] arr);
}
