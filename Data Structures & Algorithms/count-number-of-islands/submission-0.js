class Solution {
    /**
     * @param {character[][]} grid
     * @return {number}
     */
    numIslands(grid) {
         const directions = [[1, 0], [0, 1], [-1, 0], [0, -1]];

    const ROWS = grid.length;
    const COLS = grid[0].length;
    let islands = 0;


    const bfs = (r, c)  => {

        const queue = [];
        queue.push([r, c]);
        grid[r][c] = "0";

        while (queue.length > 0) {
            const [r, c] = queue.shift();

            for (const [dr, dc] of directions) {
                const nr = dr + r;
                const nc = dc + c;

                if (nr < 0 || nr === ROWS || nc < 0 || nc === COLS || grid[nr][nc] === "0") continue;

                queue.push([nr, nc]);
                grid[nr][nc] = "0";
            }
        }

    }

    for (let r = 0 ; r < ROWS; r++){
        for (let c = 0; c < COLS; c++){
            if (grid[r][c] === "1"){
                bfs(r,c);
                islands++;
            }
        }
    }


    return islands;

    }
}
