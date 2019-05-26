import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author tony.chenjy
 * @date 2019-03-08
 */
public class Main {
    public static int i = 1;
    public final static Object lock1 = new Object();
    public final static Object lock2 = new Object();

    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap map = new ConcurrentHashMap();
        // 死锁
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock1) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " start");
                        Thread.sleep(5);
                        synchronized (lock2) {
                            System.out.println(Thread.currentThread().getName());
                        }
                        System.out.println(Thread.currentThread().getName() + " end");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock2) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " start");
                        Thread.sleep(5);
                        synchronized (lock1) {
                            System.out.println(Thread.currentThread().getName());
                        }
                        System.out.println(Thread.currentThread().getName() + " end");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
    }

    /**
     * @param seqA: the list of intervals
     * @param seqB: the list of intervals
     * @return: the time periods
     */
    public List<Interval> timeIntersection(List<Interval> seqA, List<Interval> seqB) {
        // Write your code here

        List<Interval> list = new ArrayList<>(seqA.size() + seqB.size());
        int indexA = 0, indexB = 0;
        while (indexA < seqA.size() && indexB < seqB.size()) {
            if (seqA.get(indexA).start < seqB.get(indexB).start) {
                list.add(seqA.get(indexA++));
            } else {
                list.add(seqB.get(indexB++));
            }
        }
        while (indexA < seqA.size()) {
            list.add(seqA.get(indexA++));
        }
        while (indexB < seqB.size()) {
            list.add(seqB.get(indexB++));
        }

        List<Interval> mergeList = new ArrayList<>();
        for (Interval item : list) {

        }

        return null;
    }

    // Definition of Interval:
    public class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
