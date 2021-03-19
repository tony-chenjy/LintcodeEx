import etc.PrintUtil;

import java.util.*;


/**
 * @author tony.chenjy
 * @date 2019/2/8 0008 22:40
 */
public class Test {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        PrintUtil.printlnArray(new double[]{Math.pow(2, 10)});

    }
}

/**
 * s = null, t = null, return = ""
 * s = "", t = "", return = ""
 * s = "A", t = "", return = ""
 * s = "", t = "A", return = ""
 * s = "A", t = "A", return = "A"
 * s = "AB", t = "A", return = "A"
 * s = "ABCAB", t = "AC", return = "CA"
 */

/*
Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-window-substring
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */