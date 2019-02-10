package sorting_algorithm;

import etc.PrintUtil;

/**
 * @author tony.chenjy
 * @date 2019-02-10
 */
public class QuickSortTest {
    public static void main(String[] args) {
        System.out.println("test: ");

        int[] array = new int[]{3, 5, 8, 1, 2, 9, 4, 7, 6};
        quickSort(array, 0, array.length - 1);
        PrintUtil.printArray(array);
    }

    /**
     * TODO
     *
     *
     *
     */
    public static void quickSort(int[] array, int start, int end) {
    }
}
