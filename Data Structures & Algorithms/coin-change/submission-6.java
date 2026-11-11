class Solution {
    private int[] bestCount ;
    public int coinChange(int[] coins, int amount) {
        bestCount = new int[amount + 1];
        Arrays.fill(bestCount, -1);
        dfs(coins, amount, 0);
        return bestCount[0] ;
    }

    private void dfs(int[] coins, int amount, int count){

        if (amount < 0) return;

        if (bestCount[amount] != -1 && count >= bestCount[amount]){
            return;
        }

        bestCount[amount] = count;

        if (amount == 0) return;

        for (int coin : coins){
            dfs(coins, amount - coin, count + 1);
        }
    }
}
