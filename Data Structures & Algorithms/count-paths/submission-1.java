class Solution {
    private int[][] directions = new int[][]{{1,0}, {0,1}};
    private int[][] memo;

    public int uniquePaths(int m, int n) {
        memo = new int[m][n];

        for (int[] row : memo){
            Arrays.fill(row, -1);
        } 

        return dfs(m,n, 0, 0);
    }

    private int dfs(int m , int n, int r, int c){
        if (r == m -1 && c == n - 1) {
            return 1;
        };

        if (memo[r][c] != -1) return memo[r][c];

        int sum = 0;
        for (int[] dir : directions){
            int nr = dir[0] + r, nc = dir[1] + c;

            if (nr < 0 || nc < 0 || nr == m || nc == n) continue ;

            sum += dfs(m, n, nr,nc);
        }

        memo[r][c] = sum;

        return sum;

    }
}
