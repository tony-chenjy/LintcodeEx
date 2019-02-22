public class Solution {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int min = binarySearch(nums, 0, nums.length - 1);
        return min;
    }

    public int binarySearch(int[] nums, int start, int end) {
        int target = nums[end];
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                start = mid;
            } else if (nums[mid] < target) {
                end = mid;
            } else {
                int left = binarySearch(nums, start, mid);
                int right = binarySearch(nums, mid + 1, end);
                return Math.min(left, right);
            }
        }
        if (nums[start] < nums[end]) {
            return nums[start];
        } else {
            return nums[end];
        }
    }
}