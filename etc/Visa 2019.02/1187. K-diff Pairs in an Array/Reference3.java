//two pointer O(N)
//create two hashSet, One set to store Character, One Set to store the substring
//
//i start index, test every start index, to check whether it can be a substring of length K and containing different characters
//if contains duplicate character , break, start from next index
public class Solution {
    /**
     * @param stringIn: The original string.
     * @param K: The length of substrings.
     * @return: return the count of substring of length K and exactly K distinct characters.
     */
    public int KSubstring(String stringIn, int K) {
        // Write your code here
        Set<String> set = new HashSet<>();
        Set<Character> charSet = new HashSet<>();
        int j = 0;
        int len = stringIn.length();
        for (int i = 0; i <= len - K; i++) {
            while (j < len && charSet.size() < K) {
                char c = stringIn.charAt(j);
                if (charSet.contains(c)) {
                    break;
                }
                charSet.add(c);
                j ++;
                if (charSet.size() == K) {
                    set.add(stringIn.substring(i, j));
                }
            }
            charSet.remove(stringIn.charAt(i));
        }
        return set.size();
    }
}