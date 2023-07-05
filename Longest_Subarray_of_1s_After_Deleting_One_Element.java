public class Longest_Subarray_of_1s_After_Deleting_One_Element {
    public int longestSubarray(int[] nums) {
        int num_of_zeros_allowed = 1;
        int left = 0, right = 0;

        for(right = 0; right < nums.length; right++) {
            boolean is_zero = nums[right]  ==  0;
            num_of_zeros_allowed -= is_zero ? 1 : 0;

            if(num_of_zeros_allowed < 0) {
                boolean is_zero_left = nums[left] == 0;
                num_of_zeros_allowed += is_zero_left ? 1: 0;
                left += 1;
            }
        }
        return right - left - 1;
    }
}