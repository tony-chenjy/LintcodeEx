// 1. Array A represents persons infected by covid-19, nested array B represents mutual contacts for a group of people (size of inner array is guaranteed to be 2), return array C which contains all persons that might have been infected. For example, if A=[2, 4], B=[[2, 5], [7, 5], [1, 3]], return C=[5, 7]

public class Solution {

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
/*
[[2, 5], [7, 5], [1, 3]]

2 -> 5
5 -> 2, 7
7 -> 5
1 -> 3
3 -> 1
*/