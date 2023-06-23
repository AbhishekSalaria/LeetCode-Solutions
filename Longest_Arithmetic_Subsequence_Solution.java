public class Longest_Arithmetic_Subsequence_Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length, longest = 2;
        Map<Integer, Integer>[] dp = new HashMap[n];

        if(n <= 2) {
            return n;
        }

        for(int j = 0; j < n; j++) {
            dp[j] = new HashMap<>();
            for(int i = 0 ; i < j; i++) {
                int diff = nums[i] - nums[j];
                dp[j].put(diff,dp[i].getOrDefault(diff,1) + 1);
                longest =  Math.max(longest,dp[j].get(diff));
            }
        }
        return longest;
    }
}