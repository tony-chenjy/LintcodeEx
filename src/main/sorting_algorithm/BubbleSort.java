package sorting_algorithm;


/**
 * @author cm
 * @date 2019/2/8 0008 22:48
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = new int[]{5, 2, 4, 3, 8};
        bubbleSort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            System.out.print(" ");
        }
    }

    public static void bubbleSort(int[] array) {
        if (array == null || array.length < 1) {
            return;
        }

        int n = array.length;
        boolean isExchanged = false;
        for (int i = 0; i < n - 1; i++) {
            isExchanged = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    isExchanged = true;
                }
            }
            if (!isExchanged) {
                break;
            }
        }
    }
}
