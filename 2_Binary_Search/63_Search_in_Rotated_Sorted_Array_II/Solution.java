public class Solution {
    /**
     * @param A: an integer ratated sorted array and duplicates are allowed
     * @param target: An integer
     * @return: a boolean
     */
    public boolean search(int[] A, int target) {
        // write your code here
        if (A == null || A.length < 1) {
            return false;
        }
        int index = binarySearch(A, 0, A.length - 1, target);
        return (index == -1) ? false : true;
    }

    public int binarySearch (int[] array, int start, int end, int target) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (array[mid] > array[start]) {
                if (target == array[mid]) {
                    return mid;
                } else if (target >= array[start] && target < array[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else if (array[mid] < array[end]) {
                if (target == array[mid]) {
                    return mid;
                } else if (target <= array[end] && target > array[mid]) {
                    start = mid;
                } else {
                    end = mid;
                }
            } else if (array[mid] == array[start] || array[mid] == array[end]) {
                int left = binarySearch(array, start, mid, target);
                int right = binarySearch(array, mid + 1, end, target);
                if (left != -1) {
                    return left;
                } else if (right != -1) {
                    return right;
                } else {
                    return -1;
                }
            }
        }
        if (array[start] == target) {
            return start;
        }
        if (array[end] == target) {
            return end;
        }
        return -1;
    }
}