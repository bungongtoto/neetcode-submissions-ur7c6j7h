class Solution {
    private int[][] directions = new int[][]{{1,0}, {0, 1}, {-1, 0}, {0, -1}};

    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new ArrayDeque();

        int ROW = grid.length, COL = grid[0].length;

        for (int r = 0 ; r < ROW; r++){
            for (int c = 0; c < COL; c++){
                if (grid[r][c] == 0){
                    q.offer(new int[]{r,c});
                }
            }
        }

        while (!q.isEmpty()){
            int[] p = q.poll();

            for (int[] dir : directions){
                int nr = p[0] + dir[0], nc = p[1] + dir[1];

                if (nr < 0 || nc < 0 || nr == ROW || nc == COL || grid[nr][nc] == -1 || grid[nr][nc] != Integer.MAX_VALUE ) continue;

                grid[nr][nc] = grid[p[0]][p[1]] + 1;

                q.offer(new int[] {nr, nc});
            }
        }
    }
}
