import etc.PrintUtil;

import java.util.HashMap;


/**
 * @author tony.chenjy
 * @date 2019/2/8 0008 22:40
 */
public class Test {
    public static void main(String[] args) {
        new HashMap().put("a","a");
//        System.out.println(new Test().removeKdigits("1432219", 3)); // "1219"

        System.out.println(new Solution().numberOfWay(3, 3, 2, new int[][]{{1,1},{2,2}}));
        System.out.println(new Solution().numberOfWay(2, 2, 1, new int[][]{{0,1}}));
        System.out.println(new Solution().numberOfWay(2, 2, 1, new int[][]{{0,0}}));
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

class Solution {

    public int numberOfWay(int x, int y, int n, int[][] matrix) {
        int[][] dp = new int[x + 1][y + 1];

        // set boss position
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0 && matrix[i][1] == 0) {
                return 0;
            }
            dp[matrix[i][0]][matrix[i][1]] = -1;
        }

        // init dp
        for (int i = 1; i < dp.length; i++) {
            if (dp[i][0] == -1) {
                break;
            } else {
                dp[i][0] = 1;
            }
        }
        for (int j = 1; j < dp[0].length; j++) {
            if (dp[0][j] == -1) {
                break;
            } else {
                dp[0][j] = 1;
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (dp[i][j] == -1) {
                    continue;
                }

                dp[i][j] = (dp[i - 1][j] == -1 ? 0 : dp[i - 1][j]) + (dp[i][j - 1] == -1 ? 0 : dp[i][j - 1]);
            }
        }
        return dp[x][y];
    }
}