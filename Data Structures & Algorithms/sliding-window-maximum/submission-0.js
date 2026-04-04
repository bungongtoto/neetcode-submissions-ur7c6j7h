class Solution {
    /**
     * @param {number[]} nums
     * @param {number} k
     * @return {number[]}
     */
    maxSlidingWindow(nums, k) {
        let res = [];
        let l = 0, r = k - 1;

        while (r < nums.length) {
            const subA = nums.slice(l, r + 1);
            res.push(Math.max(...subA))
            l++;
            r++;
        }

        return res
    }
}
