import etc.PrintUtil;

import java.util.*;

/**
 * @author tony.chenjy
 * @date 2019/2/8 0008 22:40
 */
public class Add {
    public static void main(String[] args) {
        System.out.println(new Test().add(1, 3));
    }

    public int add(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }

        int sum = num1 ^ num2;
        int carry = (num1 & num2) << 1;
        return add(sum, carry);
    }
}
