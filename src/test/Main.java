import java.util.*;
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
        // new Main().testRandom();
        new Main().testTopK();
    }

    private void testTopK() {
        new Solution().topKFrequent(new int[]{1,1,1,2,2,3}, 2);
    }

    private void testRandom() {
        Random random = new Random();
        System.out.println(random.nextInt(10));

        double rand = Math.random();
        System.out.println(rand * 100 % 10);
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
    class Solution {
        public List<Integer> topKFrequent(int[] nums, int k) {
            if (nums == null || nums.length < 1) {
                return null;
            }

            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                Integer count = map.get(num);
                if (count == null) {
                    count = 1;
                } else {
                    count++;
                }
                map.put(num, count);
            }

            PriorityQueue<ResultType> pq = new PriorityQueue<>(k + 1);
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                pq.offer(new ResultType(entry.getKey(), entry.getValue()));
                if (pq.size() > k) {
                    pq.poll();
                }
            }

            List<Integer> list = new ArrayList<>(pq.size());
            for (int i = 0; i <= pq.size(); i++) {
                list.add(pq.poll().number);
            }
            return list;
        }

        class ResultType implements Comparable<ResultType>{
            int number;
            int count;
            public ResultType(int number, int count) {
                this.number = number;
                this.count = count;
            }

            public int compareTo(ResultType rt) {
                if (this.count == rt.count) {
                    return this.number - rt.number;
                }
                return this.count - rt.count;
            }
        }
    }
}
