class Solution {
    /**
     * @param {number} x
     * @param {number} n
     * @return {number}
     */
    myPow(x, n) {
        let res = 1;
        const isNegative = n < 0;
        n = isNegative ? -1 * n : n;

        for(let i = 0 ; i < n ; i++){
            res *= x;
        }

        return isNegative ? 1 / res : res;
    }
}
