package etc;

import java.util.List;

/**
 * @author tony.chenjy
 * @date 2019-02-09
 */
public class PrintUtil {

    // print number
    public static void printNumber(int number) {
        System.out.println(number);
    }

    // print List
    public static void printList(List list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void printlnList(List list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    // print array
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void printlnArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printlnArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.println(array[i][j]);
            }
        }
    }

    public static void printlnArray(double[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
    public static void printArray(char[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void printlnArray(char[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void printArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void printlnArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
