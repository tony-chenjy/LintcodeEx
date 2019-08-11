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

        int top = 0;
        char[] chars = new char[num.length()];

        for (int i = 0; i < num.length(); i++) {
            while (top > 0 && k > 0 && chars[top - 1] >= num.charAt(i)) {
                top--;
                k--;
            }
            chars[top++] = num.charAt(i);
        }
        PrintUtil.printArray(chars);
        System.out.println(chars.length);
        System.out.println(chars.length - k);
        return new String(chars, 0, chars.length - k);
    }
}
