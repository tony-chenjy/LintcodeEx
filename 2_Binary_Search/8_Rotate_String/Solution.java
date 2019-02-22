public class Solution {
    /**
     * @param str: An array of char
     * @param offset: An integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
        // write your code here
        if (str == null || str.length < 1) {
            return;
        }

        offset = offset % str.length;
        rotate(str, 0, str.length - offset - 1);
        rotate(str, str.length - offset, str.length - 1);
        rotate(str, 0, str.length - 1);
    }

    public void rotate(char[] str, int start, int end) {
        while (start < end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }
}