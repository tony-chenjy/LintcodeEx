import etc.PrintUtil;

import java.util.*;

/**
 * @author tony.chenjy
 * @date 2019/2/8 0008 22:40
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(new Test().removeKdigits("1432219", 3)); // "1219"
    }

    public String removeKdigits(String num, int k) {
        // write your code here
        if (num == null || num.length() < 1 || num.length() <= k) {
            return "0";
        }

        int len = num.length() - k;
        char[] stack = new char[num.length()];
        int top = 0;
        int n = 0;

        for (int i = 0; i < num.length(); i++) {
            if (top == 0) {
                stack[top++] = num.charAt(i);
                continue;
            }
            if (n < k) {
                if (num.charAt(i) < stack[top - 1]) {
                    top--;
                    n++;
                }
            }
            stack[top++] = num.charAt(i);
        }

        int count_zero = 0;
        while (count_zero < stack.length && stack[count_zero] == '0') {
            count_zero++;
        }
        if (count_zero == stack.length) {
            return "0";
        }
        return new String(stack, count_zero, len - count_zero);
    }
}
