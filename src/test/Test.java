import etc.PrintUtil;

import java.util.*;

/**
 * @author tony.chenjy
 * @date 2019/2/8 0008 22:40
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("testing");
        int[] nums = {3, 10, 1000, -99, 4, 100};
        int k = 3;

//        String[] words = new String[]{"yes","lint","code","yes","code","baby","you","baby","chrome","safari","lint","code","body","lint","code"};
//        String[] result = new Test().topKFrequentWords(words, k);
//        PrintUtil.printList(Arrays.asList(result));
    }
    /**
     * @param words: an array of string
     * @param k: An integer
     * @return: an array of string
     */
    public String[] topKFrequentWords(String[] words, int k) {
        // write your code here

        if (words == null || words.length < 1) {
            return words;
        }

        // data processor
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }

        // put into priorityqueue
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>(k, new Comparator<Pair>() {
            public int compare(Pair o1, Pair o2) {
                return o1.count - o2.count;
            }
        });
        for (String key : map.keySet()) {
            Pair pair = new Pair(key, map.get(key));
            if (queue.size() < k) {
                queue.offer(pair);
            } else {
                if (pair.count > queue.peek().count) {
                    queue.poll();
                    queue.offer(pair);
                }
            }
        }

        //
        String[] result = new String[queue.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = queue.poll().word;
        }
        return result;
    }

    public class Pair {
        public String word;
        public Integer count;

        public Pair(String word, Integer count) {
            this.word = word;
            this.count = count;
        }
    }
}
