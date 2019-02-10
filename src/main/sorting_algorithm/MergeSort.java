package sorting_algorithm;

import etc.PrintUtil;

/**
 * @author tony.chenjy
 * @date 2019-02-10
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] array = new int[]{6, 4, 3, 7, 5, 1, 2};
        mergeSort(array, 0, array.length - 1, new int[array.length]);
        PrintUtil.printArray(array);
    }

    /**
     * divide and conquer
     *
     * out-place, stable
     *
     * time complexity: O(nlogn) in worst & average & best
     *
     * space complexity: O(n)
     *
     */
    public static void mergeSort(int[] array, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }

        // divide
        int mid = start + (end - start) / 2;
        mergeSort(array, start, mid, temp);
        mergeSort(array, mid + 1, end, temp);

        // conquer
        merge(array, start, mid, end, temp);
    }

    public static void merge(int[] array, int start, int mid, int end, int[] temp) {
        int left = start;
        int right = mid + 1;
        int index =start;

        while (left <= mid && right <= end) {
            if (array[left] <= array[right]) {
                temp[index++] = array[left++];
            } else if (array[right] < array[left]) {
                temp[index++] = array[right++];
            }
        }
        while (left <= mid) {
            temp[index++] = array[left++];
        }
        while (right <= end) {
            temp[index++] = array[right++];
        }
        for (int i = start; i <= end; i++) {
            array[i] = temp[i];
        }
    }
}
