public class Solution {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // write your code here
        if (numCourses < 1) {
            return new int[]{};
        }

        Map<Integer, List<Integer>> graph = getGraph(numCourses, prerequisites);
        Map<Integer, Integer> indegrees = getIndegree(numCourses, prerequisites);
        Queue<Integer> queue = getStartNodes(indegrees);

        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            list.add(node);
            List<Integer> neighbours = graph.get(node);
            for (Integer neighbour : neighbours) {
                Integer indegree = indegrees.get(neighbour);
                if (indegree == 1) {
                    queue.offer(neighbour);
                } else {
                    indegrees.put(neighbour, indegree - 1);
                }
            }
        }

        if (list.size() != numCourses) {
            return new int[]{};
        }

        int[] result = new int[list.size()];
        for (int i = 0 ; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private Queue<Integer> getStartNodes(Map<Integer, Integer> indegrees) {
        Queue<Integer> startNodes = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : indegrees.entrySet()) {
            if (entry.getValue() == 0) {
                startNodes.offer(entry.getKey());
            }
        }
        return startNodes;
    }

    private Map<Integer, Integer> getIndegree(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> indegrees = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            indegrees.put(i, 0);
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int indegree = indegrees.get(prerequisites[i][0]);
            indegrees.put(prerequisites[i][0], indegree + 1);
        }
        return indegrees;
    }

    private Map<Integer, List<Integer>> getGraph(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        // init
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<Integer>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        return graph;
    }
}