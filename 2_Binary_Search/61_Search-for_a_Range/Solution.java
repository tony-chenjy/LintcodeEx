public class Solution {
    /**
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        // write your code here
        if (A == null || A.length < 1) {
            return new int[]{-1, -1};
        }

        int left = binarySearchLeftMost(A, target);
        int right = binarySearchRightMost(A, target);
        return new int[]{left, right};
    }

    public int binarySearchRightMost (int[] array, int target) {
        int start = 0;
        int end = array.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (array[mid] == target) {
                start = mid;
            } else if (array[mid] < target) {
                start = mid;
            } else if (array[mid] > target) {
                end = mid;
            }
        }
        if (array[end] == target) {
            return end;
        }
        if (array[start] == target) {
            return start;
        }
        return -1;
    }

    public int binarySearchLeftMost (int[] array, int target) {
        int start = 0;
        int end = array.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (array[mid] == target) {
                end = mid;
            } else if (array[mid] < target) {
                start = mid;
            } else if (array[mid] > target) {
                end = mid;
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