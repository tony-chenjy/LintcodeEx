import etc.PrintUtil;

import java.util.PriorityQueue;

/**
 * @author tony.chenjy
 * @date 2019/2/8 0008 22:40
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("testing");
        int[] nums = {3, 10, 1000, -99, 4, 100};
        int k = 3;

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k);
        for (int i = 0; i < nums.length; i++) {
            if (pq.size() < k) {
                pq.offer(nums[i]);
            } else {
                if (pq.peek() < nums[i]) {
                    pq.poll();
                    pq.offer(nums[i]);
                }
            }
        }

        int[] result = new int[pq.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = pq.poll();
        }
        PrintUtil.printArray(result);
    }
}
