public class Non_overlapping_Intervals_Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> (a[1] - b[1]));
        int countRemoval = 0;
        int endTime = Integer.MIN_VALUE;
        for(int i = 0; i < intervals.length; i++) {
            if(intervals[i][0] < endTime) {
                countRemoval++;
            }
            else {
                endTime = intervals[i][1];
            }
        }
        return countRemoval;
    }
}