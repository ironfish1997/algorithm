package search;

/**
 * @Author liyong.liu
 * @Date 2019-06-05
 **/
public interface Searable<E> {
    int search(E[] arr, E target);
}
