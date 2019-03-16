// time complexity: O(n) space complexity: O(1)
public class Solution {
    /**
     * @param nums: an array of integers
     * @param k: an integer
     * @return: the number of unique k-diff pairs
     */
    public int findPairs(int[] nums, int k) {
        // Write your code here
        Arrays.sort(nums);
        int n = nums.length, ans = 0;
        for(int i = 0, j = 0; i < n; ++i) {
            if(i == j) j++;
            while (i + 1 < n && nums[i] == nums[i + 1]) i++;
            while (j + 1 < n && nums[j] == nums[j + 1]) j++;
            while (j < n && Math.abs(nums[j] - nums[i]) < k) j++;
            if(j >= n) break;
            if (Math.abs(nums[j] - nums[i]) == k) {
                ans++;
                j++;
            }
        }
        return ans;
    }
}