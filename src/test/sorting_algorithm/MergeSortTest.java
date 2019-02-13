package sorting_algorithm;

import etc.PrintUtil;

/**
 * @author tony.chenjy
 * @date 2019-02-10
 */
public class MergeSortTest {
    public static void main(String[] args) {
        System.out.println("test: ");

        int[] array = new int[]{6, 4, 3, 7, 5, 1, 2};
        mergeSort(array, 0, array.length - 1, new int[array.length]);
        PrintUtil.printArray(array);
    }

    /**
     * TODO
     *
     *
     *
     *
     */
    public static void mergeSort(int[] array, int start, int end, int[] temp) {
    }

    public static void merge(int[] array, int start, int mid, int end, int[] temp) {
    }
}
