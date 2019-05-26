/**
 * time complexity: O(nlogk)
 * space complexity: O(n)
 */
public class Solution {
    /**
     * @param nums: an integer array
     * @param k: An integer
     * @return: the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length < 1) {
            return nums;
        }

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
        return result;
    }
}