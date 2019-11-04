package leetcode.Question_1116;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @Author: Liyong.liu
 * @Date: 2019/11/4 下午5:23
 */
class ZeroEvenOdd {
    private int n;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    private Semaphore z = new Semaphore(1);
    private Semaphore o = new Semaphore(0);
    private Semaphore e = new Semaphore(0);

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            z.acquire();
            printNumber.accept(0);
            if ((i & 1) == 0)
                o.release();
            else
                e.release();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            e.acquire();
            printNumber.accept(i);
            z.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            o.acquire();
            printNumber.accept(i);
            z.release();
        }
    }
}