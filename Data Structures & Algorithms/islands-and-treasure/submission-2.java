class Solution {
    private int[][] directions = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private int INF = 2147483647;

    public void islandsAndTreasure(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        for (int r = 0; r < ROWS; r++){
            for (int c = 0; c < COLS; c++){
                if (grid[r][c] == 0){
                    q.add(new int[]{r,c});
                }
            }
        }

        System.out.println(q.size());

        while (!q.isEmpty()){
            int[] node = q.poll();

            for (int[] dir : directions){
                int nr = node[0] + dir[0], nc = node[1] + dir[1];

                if (nr >= 0 && nr < ROWS && nc >= 0 && nc < COLS && grid[nr][nc] == INF){
                    grid[nr][nc] = grid[node[0]][node[1]] + 1;
                    q.add(new int[] {nr, nc});
                }
            }
        }
    }
}
