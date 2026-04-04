class Solution {
    public int coinChange(int[] coins, int amount) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 0);
        int minCoins = dfs(coins, amount, dp);

        return (minCoins >= 1e9)? -1 : minCoins;
    }

    private int dfs(int[] coins, int amount, Map<Integer, Integer> dp){
        if (dp.containsKey(amount)) {
            return dp.get(amount);
        }

        int res = (int) 1e9;

        for (int coin : coins){
            if (amount - coin >= 0){
                res = Math.min(res, 1 + dfs(coins, amount - coin, dp));
            }
        }

        dp.put(amount, res);

        return res;
    }
}
