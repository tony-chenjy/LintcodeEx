// TODO KMP

public class Solution {
    /**
     * @param source:
     * @param target:
     * @return: return the index
     */
    public int strStr(String source, String target) {
        // Write your code here
        if (source == null || target == null) {
            return -1;
        }
        if (source.length() == 0 && target.length() == 0) {
            return 0;
        }

        for (int i = 0, j = 0; i < source.length(); i++) {
            for (j = 0; i + j < source.length() && j < target.length(); j++) {
                if (source.charAt(i + j) != target.charAt(j)) {
                    break;
                }
            }
            if (j == target.length()) {
                return i;
            }
        }
        return -1;
    }
}