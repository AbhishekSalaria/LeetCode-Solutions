public class Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee_Solution {
        /*
        Input -> [1, 3, 2, 8, 4, 9] , fee -> 2

        buy = max(-1e9, 0 - 1) => -1
        sell = max(0, -1 + 1 - 2) = > -2

        buy = max(-1, -2 - 3) => -1
        sell = max(-2, -1 + 3 - 2) => 0

        buy = max(-1, 0 - 2) => -1
        sell = max(0, -1 + 2 - 2) => 0

        buy = max(-1, 0 - 8) => -1
        sell = max(0, -1 + 8 - 2) => 5

        buy = max(-1, 5 - 4) => 1
        sell = max(5, 1 + 4 - 2) => 5

        buy = max(1, 5 - 9) => 1
        sell = max(5, 1 + 9 - 2) = 8

        Maximum profit => 8
        */
    public int maxProfit(int[] prices, int fee) {
        int buy = Integer.MIN_VALUE;
        int sell = 0;
        for(int price : prices) {
            buy = Math.max(buy, sell - price);
            sell = Math.max(sell, buy + price - fee);
        }

        return sell;
    }
}
