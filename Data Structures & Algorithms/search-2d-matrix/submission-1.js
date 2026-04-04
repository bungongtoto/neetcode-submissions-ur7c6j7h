class Solution {
    /**
     * @param {number[][]} matrix
     * @param {number} target
     * @return {boolean}
     */
    searchMatrix(matrix, target) {
        let ROWS = matrix.length, COLS = matrix[0].length;

        // first get the row
        let top = 0, bot = ROWS - 1;
        
        while (top <= bot){
            const row = top + Math.floor((bot - top) / 2);

            if (target  > matrix[row][COLS - 1] ){
                top = row + 1;
            }else if (target < matrix[row][0]){
                bot = row - 1;
            }else {
                break;
            }
        }

        if (!(top <= bot)){
            return false;
        }

        // next perform the search in the row
        const row = top + Math.floor((bot - top) / 2);
        let l = 0 , r = COLS - 1;

        while (l <= r){
            const m = l + Math.floor((r - l) / 2);

            if (target > matrix[row][m]){
                l = m + 1;
            }else if ( target < matrix[row][m]){
                r = m -1;
            }else {
                return true;
            }
        }

        return false;

        // for (let r = 0 ; r < matrix.length; r ++){
        //     for (let c = 0; c < matrix[0].length; c++){
        //         if (matrix[r][c] === target){
        //             return true
        //         }
        //     }
        // }

        // return false;
    }
}
