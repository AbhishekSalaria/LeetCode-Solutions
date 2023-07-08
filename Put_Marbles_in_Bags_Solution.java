public class Put_Marbles_in_Bags_Solution {
    public long putMarbles(int[] weights, int k) {

        int n = weights.length;
        List<Integer> lst = new ArrayList<>();

        for(int i = 0; i < n - 1; i++) {
            lst.add(weights[i] + weights[i+1]);
        }
        Collections.sort(lst);

        long min_sum = 0, max_sum = 0;
        for(int i = 0; i < k-1; i++) {
            min_sum += lst.get(i);
            max_sum += lst.get(n-2-i);
        }
        return max_sum - min_sum;
    }
}