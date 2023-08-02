public class Permutations_Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        permutate(current, result, nums);

        return result;
    }
    public void permutate(List<Integer> current, List<List<Integer>> result, int[] nums) {
        if(current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        for(int num: nums) {
            if(!current.contains(num)) {
                current.add(num);
                permutate(current, result, nums);
                current.remove(current.size() - 1);
            }
        }
    }
}