public class Main {
    public static void main(String[] args) {
        // 数字千分位加逗号   比如:输入10000    输出 10,000
        System.out.println(new Solution().thousandSeparator(987));
        System.out.println(new Solution().thousandSeparator(1234));
        System.out.println(new Solution().thousandSeparator(123456789));
        System.out.println(new Solution().thousandSeparator(0));
    }
}

class Solution {
    public String thousandSeparator(int n) {
        String num = String.valueOf(n);
        if (n < 1000) {
            return num;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = num.length() - 1, j = 1; i >= 0; i--, j++) {
            sb.append(num.charAt(i));
            if (i > 0 && j % 3 == 0) {
                sb.append(".");
            }
        }
        return sb.reverse().toString();
    }
}