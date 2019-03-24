package multi_thread;

import java.util.concurrent.TimeUnit;

/**
 * @author tony.chenjy
 * @date 2019-03-24
 */
public class PrintOddEven_2 {
    public static int i = 1;
    public static Object lock = new Object();

    // 两个线程分别打印 1- 100，A 打印偶数， B打印奇数
    public static void main (String[] args) throws InterruptedException {

        Runnable run = new PrintOddEvenThread();
        Thread threadA = new Thread(run, "偶数");

        Thread threadB = new Thread(run, "奇数");

        threadB.start();
        Thread.sleep(1);
        threadA.start();
    }

    static class PrintOddEvenThread implements Runnable {
        public void run() {
            // print odd
            while (i < 101) {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                    i++;
                    lock.notifyAll();
                    try {
                        if (i < 101) {
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
