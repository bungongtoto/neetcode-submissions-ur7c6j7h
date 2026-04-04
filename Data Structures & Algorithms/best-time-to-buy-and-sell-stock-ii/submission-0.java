class Solution {
    public int maxProfit(int[] prices) {
        int totalProfit = 0;
        int buyIdx = 0;

        for (int i = 0; i < prices.length; i++){
            if (prices[i] < prices[buyIdx]){
                buyIdx = i;
            }else {
                totalProfit += (prices[i] - prices[buyIdx]);
                buyIdx = i;
            }
        }

        return totalProfit;
    }
}