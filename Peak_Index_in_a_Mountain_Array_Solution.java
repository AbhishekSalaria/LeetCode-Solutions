public class Peak_Index_in_a_Mountain_Array_Solution {
    public int findTheIndex(int[] range,int left, int right) {
        int mid = (left + right)/2;

        if(mid > 0 && mid < right) {
            if(range[mid] > range[mid - 1] && range[mid] > range[mid + 1]) {
                return mid;
            }
            else if(range[mid] > range[mid - 1]) {
                return findTheIndex(range, mid, right);
            }
            else {
                return findTheIndex(range, left, mid + 1);
            }

        }
        return mid;

    }
    public int peakIndexInMountainArray(int[] arr) {
        return findTheIndex(arr,0, arr.length - 1);
    }
}