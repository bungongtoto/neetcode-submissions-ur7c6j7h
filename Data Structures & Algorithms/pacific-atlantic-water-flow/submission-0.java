class Solution {

    private int[][] directions = new int[][]{{0,1}, {1,0}, {-1, 0}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROW = heights.length , COL = heights[0].length;

        Queue<int[]> pacQ = new ArrayDeque<>();
        Queue<int[]> atlQ = new ArrayDeque<>();

        for (int r = 0 ; r < ROW; r++){
            pacQ.offer(new int[]{r, 0});
            atlQ.offer(new int[]{r, COL -1});
        }

        for (int c = 0 ; c < COL; c++){
            pacQ.offer(new int[]{0, c});
            atlQ.offer(new int[]{ROW - 1, c});
        }

        boolean[][]  pac = new boolean[ROW][COL];
        boolean[][]  atl = new boolean[ROW][COL];

        bfs(pacQ, pac, heights);
        bfs(atlQ, atl, heights);

        List<List<Integer>> res = new ArrayList<>();

        for (int r = 0 ; r < ROW; r++){
            for (int c = 0 ; c < COL; c++){
                if (pac[r][c] && atl[r][c]){
                    res.add(Arrays.asList(r,c) );
                }
            }
        }

        return res;

    }


    private void bfs(Queue<int[]> q, boolean[][] ocean, int[][] heights){
        while (!q.isEmpty()){
            int[] p = q.poll();

            int r = p[0], c = p[1];
            ocean[r][c] = true;

            for (int[] dir : directions){
                int nr = r + dir[0], nc = c + dir[1];

                if (nr >= 0 && nr < ocean.length && nc >= 0 && nc < ocean[0].length && 
                !ocean[nr][nc] && heights[nr][nc] >= heights[r][c]){
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }
}
