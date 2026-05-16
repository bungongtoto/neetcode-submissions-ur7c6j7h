class Solution {
    private int ROWS;
    private int COLS;

    private int[][] directions = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};

    public int maxAreaOfIsland(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;

        int maxArea = 0;

        for (int r = 0; r < ROWS; r++){
            for (int c = 0; c < COLS; c++){
                if (grid[r][c] == 1){
                    maxArea = Math.max(maxArea, bsf(grid, r, c));
                }
            }
        }

        return maxArea;
    }

    private int bsf(int[][] grid, int r, int c){
        int area = 0;
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{r, c});
        grid[r][c] = 0;
        area++;

        while (!q.isEmpty()){
            int [] p = q.poll();

            for (int[] dir : directions){
                int nr = p[0] + dir[0], nc = p[1] + dir[1];

                if (nr >= 0 && nr < ROWS && nc >= 0 && nc < COLS && grid[nr][nc] == 1){
                    q.add(new int[]{nr, nc});
                    area++;
                    grid[nr][nc] = 0;
                }
            }
        }

        return area;

    } 
}
