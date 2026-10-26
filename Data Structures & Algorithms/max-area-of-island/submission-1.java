class Solution {
    private int[][] directions = new int[][]{{1,0}, {0,1}, {-1, 0}, {0, -1}};
    
    private int ROW;
    private int COL;
    
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        ROW = grid.length;
        COL = grid[0].length;

        for(int r = 0 ; r < ROW ; r++){
            for(int c = 0; c < COL; c++){
                if (grid[r][c] == 1){

                   maxArea = Math.max(bfs(grid, r, c), maxArea);
                }
            }
        }

        return maxArea;
    }


    private int bfs(int[][] grid, int r, int c){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c});
        grid[r][c] = 0;

        int area = 0;

        while (!q.isEmpty()){
            area++;
            int[] p = q.poll();

            for (int[] dir : directions){
                int nr = dir[0] + p[0], nc = dir[1] + p[1];

                if (nr < 0 || nc < 0 || nr == ROW || nc == COL || grid[nr][nc] == 0) continue;

                q.offer(new int[]{nr, nc});
                grid[nr][nc] = 0;
            }
        }

        return area;
    }
}
