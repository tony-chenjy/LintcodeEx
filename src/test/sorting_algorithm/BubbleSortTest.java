package sorting_algorithm;

public class BubbleSortTest {
    public static void main(String[] args) {
        System.out.println("test: ");
        int[] array = new int[]{5, 4, 2, 3, 8};
        bubbleSort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            System.out.print(" ");
        }
    }

    public static void bubbleSort(int[] array) {
    }
}
