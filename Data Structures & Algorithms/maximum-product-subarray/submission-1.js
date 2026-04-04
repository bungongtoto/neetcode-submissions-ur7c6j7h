class Solution {
    /**
     * @param {number[]} nums
     * @return {number}
     */
    maxProduct(nums) {
        let res = nums[0];

        for (let i = 0 ; i < nums.length ; i++){
            let curr = 1;

            for (let j = i ; j < nums.length; j++ ){
                curr *= nums[j];

                res = Math.max(curr, res);
            }
        }

        return res;
    }
}
