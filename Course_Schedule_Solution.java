public class Course_Schedule_Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adjacencyList = new ArrayList<>(numCourses);

        for(int i = 0; i < numCourses; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for(int[] prerequisite: prerequisites) {
            adjacencyList.get(prerequisite[1]).add(prerequisite[0]);
            indegree[prerequisite[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int nodesVisited = 0;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            nodesVisited++;

            for(int neighbor: adjacencyList.get(node)) {
                indegree[neighbor]--;
                if(indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        return nodesVisited == numCourses;
    }
}