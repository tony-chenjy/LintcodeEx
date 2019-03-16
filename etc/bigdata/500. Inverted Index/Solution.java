/**
 * Definition of Document:
 * class Document {
 *     public int id;
 *     public String content;
 * }
 */
public class Solution {
    /**
     * @param docs a list of documents
     * @return an inverted index
     */
    public Map<String, List<Integer>> invertedIndex(List<Document> docs) {
        // Write your code here

        Map<String, List<Integer>> map = new HashMap<>();
        if (docs == null || docs.isEmpty()) {
            return map;
        }

        for (Document doc : docs) {
            String[] words = doc.content.trim().split("\\s+");
            Arrays.sort(words);
            String previous = "";
            for (String word : words) {
                String now = word;
                if (!map.containsKey(word)) {
                    map.put(word, new ArrayList<Integer>());
                }
                if (!now.equals(previous)) {
                    map.get(word).add(doc.id);
                    previous = now;
                }
            }
        }
        return map;
    }
}