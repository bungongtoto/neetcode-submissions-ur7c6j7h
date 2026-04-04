class Solution {
    /**
     * @param {number[][]} grid
     */
    islandsAndTreasure(grid) {
        const ROWS = grid.length, COLS = grid[0].length;
        const N = (2**31) - 1;
        let queue = [];

        //get the treasure chest positions
        for(let r = 0 ; r < ROWS; r++){
            for (let c = 0 ; c < COLS; c++){
                if (grid[r][c] === 0) {
                    queue.push([r, c]);
                } 
            }
        }


        const directions = [[0,1], [0, -1], [1, 0], [-1, 0]];

        while (queue.length > 0){
            const n = queue.length;
            for (let i = 0 ; i < n; i++){
                const [r, c] = queue.shift();
                for (const [dr, dc] of directions){
                    const row = dr + r, col = dc + c;

                    //check outbound and water cell or if already have distance to nearest treasure
                    if (row < 0 || row === ROWS || col < 0 || col === COLS || grid[row][col] !== N ) continue;

                    grid[row][col] = grid[r][c] + 1;
                    queue.push([row, col]);
                }
            }
        }

        return grid;
    }
}
