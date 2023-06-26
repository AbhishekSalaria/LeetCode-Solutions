public class Total_Cost_to_Hire_K_Workers_Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int i = 0, j = costs.length -1;

        PriorityQueue<Integer> priorityQueue1 = new PriorityQueue<>();
        PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>();

        long result = 0;
        while(k > 0) {
            while(priorityQueue1.size() < candidates && i <= j) {
                priorityQueue1.offer(costs[i++]);
            }
            while(priorityQueue2.size() < candidates && i <= j) {
                priorityQueue2.offer(costs[j--]);
            }

            int element1 = priorityQueue1.size() > 0 ? priorityQueue1.peek() : Integer.MAX_VALUE;
            int element2 = priorityQueue2.size() > 0 ? priorityQueue2.peek() : Integer.MAX_VALUE;

            if(element1 <= element2) {
                result += element1;
                priorityQueue1.poll();
            }
            else {
                result += element2;
                priorityQueue2.poll();
            }
            k--;
        }
        return result;
    }
}