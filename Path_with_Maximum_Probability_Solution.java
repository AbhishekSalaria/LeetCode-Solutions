public class Path_with_Maximum_Probability_Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for(int i = 0; i < edges.length; i++) {
            int s = edges[i][0];
            int e = edges[i][1];;
            double probability = succProb[i];
            map.computeIfAbsent(s, x -> new ArrayList<>()).add(new int[]{e, i});
            map.computeIfAbsent(e, x -> new ArrayList<>()).add(new int[]{s, i});
        }

        double[] probabilities = new double[n];
        probabilities[start] = 1.0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while(!queue.isEmpty()) {
            int current = queue.poll();

            for(int[] neighbor: map.getOrDefault(current,new ArrayList<>())) {
                int next = neighbor[0];
                int i = neighbor[1];
                double newProbability = probabilities[current] * succProb[i];
                if(newProbability > probabilities[next]) {
                    probabilities[next] = newProbability;
                    queue.offer(next);
                }
            }
        }
        return probabilities[end];
    }
}
