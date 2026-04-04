class Solution {
    /**
     * @param {character[][]} board
     * @return {boolean}
     */
    isValidSudoku(board) {
        const cols = {};
        const rows = {};
        const squares = {};

        for (let r = 0 ; r < 9; r++){
            for (let c = 0 ; c < 9 ; c++){
                if (board[r][c] === '.'){
                    continue;
                }
                if (!rows[r]){
                    rows[r] = []
                }

                if (!cols[c]){
                    cols[c] = []
                }

                if (!squares[[Math.floor(r/3), Math.floor(c/3)]]){
                    squares[[Math.floor(r/3), Math.floor(c/3)]] = []
                }

                if (rows[r].includes(board[r][c]) || cols[c].includes(board[r][c]) ||  squares[[Math.floor(r/3), Math.floor(c/3)]].includes(board[r][c])){
                    return false;
                }

                rows[r].push(board[r][c]);
                cols[c].push(board[r][c]);
                squares[[Math.floor(r/3), Math.floor(c/3)]].push(board[r][c]);
            }
        }

        return true;
    }
}
