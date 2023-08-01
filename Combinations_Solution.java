public class Combinations_Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        getCombinations(1,n,k, new ArrayList<Integer>(), result);
        return result;
    }

    private void getCombinations(int start, int n, int k, List<Integer> combination, List<List<Integer>> result) {
        if(k == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }
        for(int i = start; i <= n - k + 1; i++){
            combination.add(i);
            getCombinations(i+1,n,k-1,combination, result);
            combination.remove(combination.size() - 1);
        }
    }
}