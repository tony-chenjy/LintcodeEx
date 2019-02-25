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

        quickSort(nums, 0, nums.length - 1);
        if (k >= nums.length) {
            return nums;
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = nums[i];
        }
        return result;
    }

    private void quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        int pivot = array[start + (end - start) / 2];
        while (left <= right) {
            while (left <= right && array[left] > pivot) {
                left++;
            }
            while (right >= left && array[right] < pivot) {
                right--;
            }
            if (left <= right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
        }
        quickSort(array, start, right);
        quickSort(array, left, end);
    }
}