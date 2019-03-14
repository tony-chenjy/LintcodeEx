public class Solution {
    /**
     * @param paragraph:
     * @param banned:
     * @return: nothing
     */
    public String mostCommonWord(String paragraph, String[] banned) {
        //

        String[] words = paragraph.toLowerCase().replaceAll("[!?',;.]", "").trim().split(" ");
        Set<String> set = new HashSet<>();
        for (String item : banned) {
            set.add(item);
        }

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (map.containsKey(word)) {
                Integer count = map.get(word);
                count++;
                map.put(word, count);
            } else {
                map.put(word, 1);
            }
        }

        String maxWord = null;
        int max = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (set.contains(entry.getKey())) {
                continue;
            }
            if (entry.getValue() > max) {
                max = entry.getValue();
                maxWord = entry.getKey();
            }
        }
        return maxWord;
    }
}