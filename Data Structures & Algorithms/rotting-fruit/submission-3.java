class Solution {
    private int[][] directions = new int[][]{{1,0}, {0, 1}, {-1, 0}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();

        int ROW = grid.length, COL = grid[0].length;

        int fresh = 0;

        for (int r = 0 ; r < ROW; r++){
            for (int c = 0; c < COL; c++){
                if (grid[r][c] == 1){
                    fresh++;
                }
                if (grid[r][c] == 2){
                    q.offer(new int[]{r,c});
                }
            }
        }

        if (fresh == 0) return 0;

        int minutes = 0;

        while (!q.isEmpty()){
            minutes++;
            int n = q.size();

            for (int i = 0 ; i < n ; i++){
                int[] p = q.poll();

                for (int[] dir : directions){
                    int nr = p[0] + dir[0], nc = p[1] + dir[1];

                    if (nr < 0 || nc < 0 || nr == ROW || nc == COL || grid[nr][nc] == 0 || grid[nr][nc] == 2 ) continue;

                    grid[nr][nc] = 2;
                    fresh--;

                    q.offer(new int[] {nr, nc});
                }
            }
        }


        return fresh == 0 ? minutes - 1 : -1;
    }
}
