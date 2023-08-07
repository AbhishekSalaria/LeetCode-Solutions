public class Search_a_2D_Matrix_Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int low = 0;
        int high = n*m - 1;
        while(low <= high) {
            int mid = (low + high) / 2 ;

            int index = mid % m;
            int row = mid / m;

            if(matrix[row][index] == target) {
                return true;
            }
            else if(matrix[row][index] > target) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return false;
    }
}