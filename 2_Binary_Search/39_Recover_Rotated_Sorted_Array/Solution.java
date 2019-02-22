public class Solution {
    /**
     * @param nums: An integer array
     * @return: nothing
     */
    public void recoverRotatedSortedArray(List<Integer> nums) {
        // write your code here
        // find minimum index
        if (nums == null || nums.isEmpty()) {
            return;
        }

        int min = findMinInRotatedArray(nums, 0, nums.size() - 1);
        rotate(nums, 0, min - 1);
        rotate(nums, min, nums.size() - 1);
        rotate(nums, 0, nums.size() - 1);
    }

    public void rotate(List<Integer> nums, int start, int end) {
        while (start < end) {
            int temp = nums.get(start);
            nums.set(start, nums.get(end));
            nums.set(end, temp);
            start++;
            end--;
        }
    }

    public int findMinInRotatedArray(List<Integer> nums, int start, int end) {
        int target = nums.get(end);
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums.get(mid) < target) {
                end = mid;
            } else if (nums.get(mid) > target) {
                start = mid;
            } else {
                int left = findMinInRotatedArray(nums, start, mid);
                int right = findMinInRotatedArray(nums, mid + 1, end);
                return nums.get(left) < nums.get(right) ? left : right;
            }
        }
        if (nums.get(start) > nums.get(end)) {
            return end;
        } else {
            return start;
        }
    }
}