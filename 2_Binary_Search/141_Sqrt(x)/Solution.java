public class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here
        if (x < 0) {
            return -1;
        }

        long start = 0;
        long end = x / 2 + 1;
        long target = x;
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            long result = mid * mid;
            if (result == target) {
                return (int)mid;
            } else if (result > target) {
                end = mid;
            } else if (result < target) {
                start = mid;
            }
        }
        if ((end * end) <= target) {
            return (int)end;
        } else {
            return (int)start;
        }
    }
}