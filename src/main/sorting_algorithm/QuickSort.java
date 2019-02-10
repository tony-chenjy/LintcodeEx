package sorting_algorithm;

import etc.PrintUtil;

/**
 * @author tony.chenjy
 * @date 2019-02-10
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[]{3, 5, 8, 1, 2, 9, 4, 7, 6};
        quickSort(array, 0, array.length - 1);
        PrintUtil.printArray(array);
    }

    /**
     * in-place, unstable
     *
     * time complexity: O(n^2) in worst, O(nlogn) in average, O(nlogn) in best
     *
     * space complexity: O(1)
     *
     */
    public static void quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }

        int left = start;
        int right = end;
        int pivot = array[start + (end - start) / 2];
        while (left <= right) {
            while (left <= right && array[left] < pivot) {
                left++;
            }
            while (left <= right && array[right] > pivot) {
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
