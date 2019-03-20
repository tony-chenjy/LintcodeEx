//利用哈希表记录每个单词出现的次数即可
public class Solution {
    /**
     * @param paragraph:
     * @param banned:
     * @return: nothing
     */
    public String mostCommonWord (String paragraph, String[] banned) {
        Set<String> ban = new HashSet<> (Arrays.asList (banned));
        Map<String, Integer> count = new HashMap<>();
        String[] words = paragraph.replaceAll ("\\pP", " ").toLowerCase().split ("\\s+");
        for (String w : words) if (!ban.contains (w)) count.put (w, count.getOrDefault (w, 0) + 1);
        return Collections.max (count.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}