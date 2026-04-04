class Solution {
    /**
     * @param {number[][]} matrix
     * @param {number} target
     * @return {boolean}
     */
    searchMatrix(matrix, target) {
        // first get the row
        // next perform the search in the row

        for (let r = 0 ; r < matrix.length; r ++){
            for (let c = 0; c < matrix[0].length; c++){
                if (matrix[r][c] === target){
                    return true
                }
            }
        }

        return false;
    }
}
