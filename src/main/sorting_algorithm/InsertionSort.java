package sorting_algorithm;

import etc.PrintUtil;

/**
 * @author tony.chenjy
 * @date 2019-02-09
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] array = new int[]{5, 3, 4, 7, 2};
        insertionSort(array);
        PrintUtil.printArray(array);
    }

    /**
     * in-place, stable
     *
     * time complexity: O(n^2) in worst, O(n^2) in average, O(n) in best
     *
     * space complexity: O(1)
     *
     * @param array
     */
    public static void insertionSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }
}
