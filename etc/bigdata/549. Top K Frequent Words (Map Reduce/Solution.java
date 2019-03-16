/**
 * Definition of OutputCollector:
 * class OutputCollector<K, V> {
 *     public void collect(K key, V value);
 *         // Adds a key/value pair to the output buffer
 * }
 * Definition of Document:
 * class Document {
 *     public int id;
 *     public String content;
 * }
 */
public class TopKFrequentWords {

    static class ResultType implements Comparable<ResultType>{
        String word;
        Integer count;
        public ResultType(String word, Integer count) {
            this.word = word;
            this.count = count;
        }
        public int compareTo(ResultType obj) {
            if (this.count != obj.count) {
                return this.count - obj.count;
            } else {
                return obj.word.compareTo(this.word);
            }
        }
    }

    public static class Map {
        public void map(String key, Document value,
                        OutputCollector<String, Integer> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, int value);

            String[] words = value.content.trim().split("\\s+");
            for (String word : words) {
                output.collect(word, 1);
            }
        }
    }

    public static class Reduce {
        private PriorityQueue<ResultType> pq;
        private int k;

        public void setup(int k) {
            // initialize your data structure here
            this.k = k;
            this.pq = new PriorityQueue<ResultType>(k);
        }

        public void reduce(String key, Iterator<Integer> values) {
            // Write your code here
            int sum = 0;
            while (values.hasNext()) {
                sum += values.next();
            }

            ResultType resultType = new ResultType(key, sum);
            if (pq.size() < k) {
                pq.offer(resultType);
            } else {
                if (resultType.compareTo(pq.peek()) > 0) {
                    pq.poll();
                    pq.offer(resultType);
                }
            }
        }

        public void cleanup(OutputCollector<String, Integer> output) {
            // Output the top k pairs <word, times> into output buffer.
            // Ps. output.collect(String key, Integer value);
            List<ResultType> list = new ArrayList<>();
            while (!pq.isEmpty()) {
                list.add(pq.poll());
            }

            for (int i = list.size() - 1; i >= 0; i--) {
                ResultType resultType = list.get(i);
                output.collect(resultType.word, resultType.count);
            }
        }
    }
}