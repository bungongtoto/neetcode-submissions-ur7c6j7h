class Solution {
    private int[][] directions = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();

        int freshF = 0;

        //add all rotten fruits points to the queue
        for(int r = 0 ; r < grid.length ; r++){
            for (int c = 0 ; c < grid[0].length; c++){
                if (grid[r][c] == 2){
                    queue.offer(new int[]{r, c});
                }else if (grid[r][c] == 1){
                    freshF++;
                }
            }
        }

        int minutes = 0;
        while (!queue.isEmpty() && freshF != 0){
            int n = queue.size();

            System.out.println(n);

            for (int i = 1 ; i <= n ; i++){
                int[] node  = queue.poll();
                
                int row = node[0], col = node[1];

                for (int [] dir : directions){
                    int r = row + dir[0], c = col + dir[1];

                    if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != 1) continue;

                    grid[r][c] = 2;
                    queue.offer(new int[] {r, c});
                    freshF--;
                }
            }

            minutes++;
        }

        return freshF == 0 ? minutes : -1;
    }
}
