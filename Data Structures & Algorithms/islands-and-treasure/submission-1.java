class Solution {
    private int[][] directions = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();

        //add all treasure chest points to the queue
        for(int r = 0 ; r < grid.length ; r++){
            for (int c = 0 ; c < grid[0].length; c++){
                if (grid[r][c] == 0){
                    queue.offer(new int[]{r, c});
                }
            }
        }

        if (queue.size() == 0) return;

        while (!queue.isEmpty()){
            int[] node = queue.poll();
            int row = node[0], col = node[1];

            for (int[] dir : directions){
                int r = row + dir[0], c = col + dir[1];
                if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != Integer.MAX_VALUE) continue;

                queue.offer(new int[] {r, c});
                grid[r][c] = grid[row][col] + 1;

            }
        }
    }
}
