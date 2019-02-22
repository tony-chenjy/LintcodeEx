public class Solution {
    /**
     * @param A: an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return -1;
        }

        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] > A[start]) {
                if (A[mid] == target) {
                    return mid;
                } else if (A[mid] > target && target >= A[start]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else if (A[mid] < A[end]) {
                if (A[mid] == target) {
                    return mid;
                } else if (A[mid] < target && target <= A[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        if (A[start] == target) {
            return start;
        }
        if (A[end] == target) {
            return end;
        }
        return -1;
    }
}