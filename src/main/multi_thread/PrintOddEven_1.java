package multi_thread;

/**
 * @author tony.chenjy
 * @date 2019-03-24
 */
public class PrintOddEven_1 {
    public static int i = 1;
    public static Object lock = new Object();

    // 两个线程分别打印 1- 100，A 打印偶数， B打印奇数
    public static void main (String[] args) throws InterruptedException {

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                // print even
                while (i < 101) {
                    synchronized (lock) {
                        if (i % 2 == 0) {
                            System.out.println(Thread.currentThread().getName() + ": " + i);
                            i++;
                        }
                    }
                }
            }
        }, "偶数");

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                // print odd
                while (i < 101) {
                    synchronized (lock) {
                        if (i % 2 == 1) {
                            System.out.println(Thread.currentThread().getName() + ": " + i);
                            i++;
                        }
                    }
                }
            }
        }, "奇数");

        threadA.start();
        threadB.start();
    }
}
