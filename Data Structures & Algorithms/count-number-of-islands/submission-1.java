class Solution {
    private final int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int numIslands(char[][] grid) {
        int ROWS = grid.length - 1;
        int COLS = grid[0].length - 1;

        int islands = 0;

        for(int r = 0 ; r <= ROWS ; r++){
            for (int c = 0; c <= COLS ; c++){
                if(grid[r][c] == '1'){
                    bfs(grid, r, c);
                    islands++;
                }
            }
        }

        return islands;
    }

    private void bfs(char [][] grid, int r, int c){
        Queue<int[]> q = new ArrayDeque<>();

        grid[r][c] = '0';
        q.offer(new int[]{r, c});

        while(!q.isEmpty()){
            int [] node = q.poll();
            int row = node[0], col = node[1];


            for (int [] dir: directions){
                int nr = row + dir[0];
                int nc = col + dir[1];

                if (nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length || grid[nr][nc] == '0') continue;

                grid[nr][nc] = '0';
                q.offer(new int[]{nr, nc});
            }
        }
    }
}
