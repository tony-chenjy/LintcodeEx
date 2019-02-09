package sorting_algorithm;

import etc.PrintUtil;

/**
 * @author tony.chenjy
 * @date 2019-02-09
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] array = new int[]{4, 2, 3, 6, 5};
        selectionSort(array);
        PrintUtil.printArray(array);
    }

    /**
     * in-place, stable
     *
     * time complexity: O(n^2) in worst & average & best
     *
     * space complexity: O(1)
     *
     */
    public static void selectionSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        int min;
        for (int i = 0; i < array.length; i++) {
            min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
    }
}
