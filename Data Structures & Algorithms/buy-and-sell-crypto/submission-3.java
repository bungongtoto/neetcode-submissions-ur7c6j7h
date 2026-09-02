class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buy = prices[0];
        int n = prices.length;
        int l = 0 ;

        while (l < n){
            if (buy >= prices[l]){
                buy = prices[l];
            }else {
                profit = Math.max(profit, (prices[l] - buy));
            }
            l++;
        }

        return profit;

    }
}
