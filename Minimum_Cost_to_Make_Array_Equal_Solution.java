public class Minimum_Cost_to_Make_Array_Equal_Solution {
    public long minCost(int[] nums, int[] cost) {
        int min = nums[0];
        int max = nums[0];

        for(int i: nums) {
            min = Math.min(i,min);
            max = Math.max(i,max);
        }

        long result = 0;
        while(min < max) {
            int mid = (min + max)/2;
            long costMid = findCost(nums,cost,mid);
            long costMidPlusOne = findCost(nums, cost, mid + 1);
            if(costMid > costMidPlusOne) {
                min = mid + 1;
                result = costMidPlusOne;
            }
            else {
                max = mid;
                result = costMid;
            }
        }
        return result;
    }
    public long findCost(int[] nums, int[] cost, int element) {
        long totalCost = 0L;
        for(int i=0 ; i < nums.length;i++) {
            totalCost += 1L * Math.abs(nums[i] - element) * cost[i];
        }
        return totalCost;
    }
}
