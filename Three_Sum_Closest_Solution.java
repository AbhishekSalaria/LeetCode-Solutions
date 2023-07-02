public class Three_Sum_Closest_Solution {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int currentClosest = Integer.MAX_VALUE;
        int currentDifference = Integer.MAX_VALUE;
        int difference = 0;
        for(int i = 0; i < nums.length-2;i++) {
            int j = i + 1;
            int k = nums.length - 1;

            while(j < k) {
                if((nums[i] + nums[j] + nums[k]) == target) {
                    return target;
                }
                else if ((nums[i] + nums[j] + nums[k]) < target){
                    difference = target - (nums[i] + nums[j] + nums[k]);
                    if(difference < currentDifference) {
                        currentDifference = difference;
                        currentClosest = (nums[i] + nums[j] + nums[k]);
                    }
                    j += 1;
                    while ( j < k && nums[j] == nums[j-1]) {
                        j += 1;
                    }
                }
                else {
                    difference = (nums[i] + nums[j] + nums[k]) - target;
                    if(difference < currentDifference) {
                        currentDifference = difference;
                        currentClosest = (nums[i] + nums[j] + nums[k]);
                    }
                    k -= 1;
                    while ( j < k && nums[k] == nums[k+1]) {
                        k -= 1;
                    }
                }
            }
        }
        return currentClosest;
    }
}
