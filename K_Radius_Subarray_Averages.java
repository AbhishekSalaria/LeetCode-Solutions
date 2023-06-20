public class K_Radius_Subarray_Averages {
    public int[] getAverages(int[] nums, int k) {
        int arr[] = new int[nums.length];
        long memorizeSum = 0;
        long memorizeNumber = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i - k < 0 || i + k >= nums.length) {
                arr[i] = -1;
            } else {
                if (memorizeSum != 0 || memorizeNumber != 0) {
                    memorizeSum -= memorizeNumber;
                    memorizeNumber = nums[i - k];
                    memorizeSum += nums[i + k];
                    arr[i] = (int) (memorizeSum / (2 * k + 1));
                } else {
                    int j = i - k;
                    memorizeNumber = nums[j];
                    while (j <= i + k) {
                        memorizeSum += nums[j];
                        j++;
                    }
                    arr[i] = (int) (memorizeSum / (2 * k + 1));
                }
            }
        }
        return arr;
    }
}