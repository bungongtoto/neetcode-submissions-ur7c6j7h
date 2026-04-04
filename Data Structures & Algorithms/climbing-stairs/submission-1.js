class Solution {
    /**
     * @param {number} n
     * @return {number}
     */
    climbStairs(n) {
        const memo = {};

        const dfs = (n , memo) => {
            if (n < 0 ) return 0;
            if (n=== 0 || n === 1) return 1;

            if (memo[n]) return memo[n];

            memo[n] = dfs(n -1, memo) + dfs(n - 2, memo);

            return memo[n]
        }

        return dfs(n, memo);
    }
}
