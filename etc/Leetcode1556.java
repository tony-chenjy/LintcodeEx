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