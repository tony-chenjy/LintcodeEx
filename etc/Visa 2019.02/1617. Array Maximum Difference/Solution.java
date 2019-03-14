public class Solution {
    /**
     * @param a: the array a
     * @return: return the maximum value
     */
    public int getAnswer(int[] a) {
        // Write your code here

        int max = 0;
        if (a == null) {
            return max;
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 1) {
                for (int j = i + 1; j < a.length; j++) {
                    if (a[j] % 2 == 0) {
                        int diff = a[j] - a[i];
                        max = Math.max(max, diff);
                    }
                }
            }
        }
        return max;
    }
}