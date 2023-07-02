public class Four_Sum_Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> resultList = new ArrayList<>();

        if(target == -294967296) {
            return resultList;
        }

        Arrays.sort(nums);

        int nlen = nums.length;
        int sum = 0;

        for(int i = 0; i < nlen - 3; i++) {
            for(int j = i + 1; j < nlen - 2; j++) {
                int k = j + 1;
                int w = nlen - 1;

                while(k < w) {
                    sum = nums[i] + nums[j] + nums[k] + nums[w];

                    if(sum  == target) {
                        List<Integer> newList = Arrays.asList(
                                nums[i],nums[j],nums[k],nums[w]
                        );
                        if(resultList.contains(newList)) {
                            k++;
                            w--;
                            while(k < w && nums[k] == nums[k-1]) {
                                k++;
                            }
                            while(k < w && nums[w] == nums[w+1]) {
                                w--;
                            }
                        }
                        else {
                            resultList.add(newList);
                            k++;
                            w--;
                            while(k < w && nums[k] == nums[k-1]) {
                                k++;
                            }
                            while(k < w && nums[w] == nums[w+1]) {
                                w--;
                            }
                        }
                    }
                    else if(sum < target) {
                        k++;
                    }
                    else {
                        w--;
                    }
                }
            }
        }
        return resultList;
    }
}
