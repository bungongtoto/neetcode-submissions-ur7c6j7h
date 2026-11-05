class Solution {
    public int climbStairs(int n) {
        return dfs(n, new HashMap<>());
    }

    private int dfs(int n, Map<Integer, Integer> cache){
        if (n == 0) return 1;
        if (n < 0) return 0;

        if (cache.containsKey(n)) return cache.get(n);
        int count = dfs(n -1, cache) + dfs(n - 2, cache);
        cache.put(n, count);
        return  count;
    }
}
