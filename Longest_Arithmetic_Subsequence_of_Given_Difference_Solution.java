public class Longest_Arithmetic_Subsequence_of_Given_Difference_Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> dp = new HashMap<>();
        int answer = 1;

        for (int a : arr) {
            int beforeA = dp.getOrDefault(a - difference, 0);
            dp.put(a, beforeA + 1);
            answer = Math.max(answer, dp.get(a));
        }

        return answer;
    }
}