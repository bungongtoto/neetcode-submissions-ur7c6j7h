class Solution {
    /**
     * @param {number[][]} grid
     * @return {number}
     */
    orangesRotting(grid) {
        const ROWS = grid.length, COLS = grid[0].length;
        let time = 0, fresh = 0;
        let queue = [];

        //count goog fruits and collect the index of rotten fruits
        for (let r = 0 ; r < ROWS ; r++){
            for (let c = 0 ; c < COLS; c++){
                //count good fruits
                if (grid[r][c] === 1) fresh++;

                //collect rotten oranges;
                if (grid[r][c] === 2){
                    queue.push([r, c]);
                }
            }
        }

        //directions
        const directions = [[0,1], [0, -1], [1, 0], [-1, 0]];

        while (queue.length > 0 && fresh > 0){
            const n = queue.length;
            for (let i = 0 ; i < n ; i++){
               const [r, c] = queue.shift();

                for (const [dr, dc] of directions){
                    let row = dr + r, col = dc + c;

                    //check if in bound and is not fresh
                    if (row < 0 || row === ROWS || col < 0 || col === COLS || grid[row][col] !== 1) continue;

                    //if it is fresh
                    grid[row][col] = 2;
                    queue.push([row, col]);
                    fresh -= 1;
                } 
            }

            time += 1;
        }
        console.log(time, fresh);
        return fresh === 0 ? time : -1;
    }
}
