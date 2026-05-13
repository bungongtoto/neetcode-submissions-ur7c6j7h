class Solution {
    private final int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private int ROWS;
    private int COLS;

    public int numIslands(char[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;

        int islands = 0;

        for (int r = 0 ; r < ROWS; r ++ ){
            for (int c = 0 ; c < COLS; c++){
                if (grid[r][c] == '1'){
                    bfs(grid, r, c);
                    islands++;
                }
            }
        }

        return islands;
    }

    private void bfs(char[][] grid, int r, int c){
        Queue<int[]> q = new ArrayDeque<>();
        grid[r][c] = '0';
        q.offer(new int[]{r,c});

        

        while (!q.isEmpty()){
            System.out.println(q.size());
            int[] pair = q.poll();

            int pr = pair[0], pc = pair[1];

            for (int[] dir : directions){
                int nr = pr + dir[0], nc = pc + dir[1];

                if (nr < 0 || nr == ROWS || nc < 0 || nc == COLS || grid[nr][nc] != '1' ) continue;

                grid[nr][nc] = '0';
                q.offer(new int[]{nr, nc});
            } 
        }
    }

    
}
