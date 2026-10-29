class Solution {
    private int[][] directions = new int[][]{{1,0}, {0,1}, {-1, 0}, {0, -1}};

    private boolean[][] b ;

    private int ROW;
    private int COL;

    public void solve(char[][] board) {
        ROW = board.length;
        COL = board[0].length;

        b = new boolean[ROW][COL];


        for (int r = 0; r < ROW; r++){
            for (int c = 0; c < COL; c++){
                if (board[r][c] == 'O' && !b[r][c]){
                    bfs(board, r, c);
                }else {
                    b[r][c] = true;
                }
            }
        }
    }


    private void bfs(char[][] board, int r, int c){
        Queue<int[]> q = new ArrayDeque<>();
        List<int[]> visited = new ArrayList<>();

        q.offer(new int[]{r, c});
        visited.add(new int[]{r, c});
        b[r][c] = true;

        boolean isedge = false;

        if (r == 0 || c == 0 || r == ROW - 1 || c == COL - 1){
            isedge = true;
        }

        while (!q.isEmpty()){
            int[] p = q.poll();

            for (int[] dir : directions){
                int nr = p[0] + dir[0], nc = p[1] + dir[1];


                if (nr >= 0 && nc >= 0 && nr < ROW && nc < COL && !b[nr][nc] && board[nr][nc] == 'O'){
                    if (nr == 0 || nc == 0 || nr == ROW - 1 || nc == COL - 1){
                        isedge = true;
                    }

                    visited.add(new int[]{nr, nc});
                    q.offer(new int[]{nr, nc});

                    b[nr][nc] = true;
                }
            }
        }


        if (!isedge){
            for (int[] p : visited){
                board[p[0]][p[1]] = 'X';
            }
        }
    }
}
