
import java.util.*;
import etc.PrintUtil;

public class Main {
    public static void main(String[] args) {
        PrintUtil.printList(new Solution().getArray(
            Arrays.asList(2, 4), 
            Arrays.asList(Arrays.asList(2, 5), Arrays.asList(7, 5), Arrays.asList(1, 3))));
    }
}

class Solution {

    public List<Integer> getArray(List<Integer> A, List<List<Integer>> B) {
        Map<Integer, List<Integer>> graph = buildGraph(B);

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        for (Integer item : A) {
            queue.offer(item);
            visited.add(item);
        }

        List<Integer> resultList = new ArrayList<>();
        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            List<Integer> neighbours = graph.get(node);
            if (neighbours == null || neighbours.isEmpty()) {
                continue;
            }
            for (Integer neighbour : neighbours) {
                if (visited.contains(neighbour)) {
                    continue;
                }
                resultList.add(neighbour);
                queue.offer(neighbour);
                visited.add(neighbour);
            }
        }
        return resultList;
    }

    private Map<Integer, List<Integer>> buildGraph(List<List<Integer>> B) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        // [[2, 5], [7, 5], [1, 3]]
        for (List<Integer> list : B) {
            Integer item0 = list.get(0);
            Integer item1 = list.get(1);
            addToNeighbour(item0, item1, graph);
            addToNeighbour(item1, item0, graph);
        }
        return graph;
    }

    // addToNeighbour
    private void addToNeighbour(Integer item0, Integer item1, Map<Integer, List<Integer>> graph) {
        List<Integer> neighbours = graph.getOrDefault(item0, new ArrayList<>());
        neighbours.add(item1);
        if (!graph.containsKey(item0)) {
            graph.put(item0, neighbours);
        }
    }
}