//双指针，O(n)时间法度。
//i从0开始loop，j也从0开始，但每一个新i的循环，j不返回，继续往前。
//用一个HashMap来保存当前substring里的字母，找到长度为k且不包含重复字母的substring后，remove i所指的字母，i++，继续寻找。
public class Solution {
    /**
     * @param stringIn: The original string.
     * @param K: The length of substrings.
     * @return: return the count of substring of length K and exactly K distinct characters.
     */
    public int KSubstring(String stringIn, int K) {
        if (stringIn == null || stringIn.length() == 0 || K <= 0) {
            return 0;
        }
        int count = 0;
        HashMap<Character, Integer> charMap = new HashMap<>();
        HashSet<String> resultSet = new HashSet<String>();
        int len = stringIn.length();
        int j = 0;
        for (int i = 0; i < len; i++) {
            while (j < len && charMap.size() < K) {
                char c = stringIn.charAt(j);
                if (charMap.containsKey(c)) {
                    break;
                }
                charMap.put(c, 1);
                j++;
                if (charMap.size() == K) {
                    resultSet.add(stringIn.substring(i, j));
                }
            }
            charMap.remove(stringIn.charAt(i));
        }
        return resultSet.size();
    }
}