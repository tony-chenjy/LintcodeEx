// time complexity: O(n) space complexity: O(n)
public class Solution {
    /**
     * @param nums: an array of integers
     * @param k: an integer
     * @return: the number of unique k-diff pairs
     */
    public int findPairs(int[] nums, int k) {
        // Write your code here

        if (nums == null || nums.length < 1) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                if (entry.getValue() > 1) {
                    count++;
                }
            } else {
                if (map.containsKey(entry.getKey() + k)) {
                    count++;
                }
            }
        }
        return count;
    }
}