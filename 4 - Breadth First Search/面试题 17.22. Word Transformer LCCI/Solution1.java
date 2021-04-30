public class Solution1 {
    
}

// dfs : no need to remove from visited

class Solution {
    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return new ArrayList<>();
        }

        List<String> resultList = new ArrayList<>();
        List<String> list = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        list.add(beginWord);
        visited.add(beginWord);
        dfs(resultList, list, wordSet, visited, endWord);
        return resultList;
    }

    private void dfs(List<String> resultList, List<String> list, Set<String> wordSet, Set<String> visited, String endWord) {
        if (!resultList.isEmpty()) {
            return;
        }
        
        String word = list.get(list.size() - 1);
        if (word.equals(endWord)) {
            resultList.addAll(list);
            return;
        }

        for (int i = 0; i < word.length(); i++) {
            char[] chars = word.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                chars[i] = c;
                String nextWord = new String(chars);
                if (wordSet.contains(nextWord) && !visited.contains(nextWord)) {
                    list.add(nextWord);
                    visited.add(nextWord);
                    dfs(resultList, list, wordSet, visited, endWord);
                    list.remove(list.size() - 1);
                    // no need to remove from visited
                }
            }
        }
    }
}

/** dfs
 * hit
 * hot
 * dot, lot
 * dog, log
 * cog
 */