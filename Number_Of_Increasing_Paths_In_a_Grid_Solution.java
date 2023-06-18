public class Number_Of_Increasing_Paths_In_a_Grid_Solution {

    int mod = (int)(1e9+7);
    public int countPaths(int[][] grid) {
        int total = 0;
        int [][] dummy = new int[grid.length][grid[0].length];
        for(int[] arr: dummy){
            Arrays.fill(arr,-1);
        }
        for(int i = 0 ; i < grid.length; i++) {
            for(int j = 0 ; j < grid[0].length; j++) {
                total += bfs(0,-1,i,j,grid, dummy);
                total %= mod;
            }
        }
        return total;
    }

    public int bfs(int initialCount, int previousElement, int i, int j, int grid[][], int dummy[][]) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] <= previousElement) {
            return 0;
        }

        if(dummy[i][j] != -1) {
            return dummy[i][j];
        }


        int down = bfs(initialCount, grid[i][j], i + 1, j, grid,dummy) % mod;
        int right = bfs(initialCount, grid[i][j], i, j + 1, grid,dummy) % mod;
        int up = bfs(initialCount, grid[i][j], i - 1, j, grid,dummy) % mod;
        int left = bfs(initialCount, grid[i][j], i, j - 1, grid,dummy) % mod;


        return dummy[i][j] = (1 + left + right + up + down)  % mod;
    }
}