public class Knight_Probability_in_Chessboard_Solution {
    public double knightProbability(int n, int k, int row, int column) {
        int [][] directions = {{1,2},{-1,2},{1,-2},{-1,-2},{2,1},{2,-1},{-2,1},{-2,-1}};

        double [][][] dp = new double[k+1][n][n];
        dp[0][row][column] = 1.0;

        int previousI;
        int previousJ;

        for(int m = 1; m <= k; m++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    for(int[] direction: directions) {
                        previousI = i - direction[0];
                        previousJ = j - direction[1];

                        if(previousI >= 0 && previousI < n && previousJ >= 0 && previousJ < n) {
                            dp[m][i][j] += dp[m-1][previousI][previousJ] / 8.0;
                        }
                    }
                }
            }
        }

        double answer = 0.0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                answer += dp[k][i][j];;
            }
        }

        return answer;
    }
}