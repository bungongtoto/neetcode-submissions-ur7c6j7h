class Solution {
    /**
     * @param {number[]} nums
     * @return {number[]}
     */
    productExceptSelf(nums) {
        const n = nums.length;
        const res = new Array(n);
        const prefix = new Array(n);
        const suffix = new Array(n);

        prefix[0] = 1;
        suffix[n-1] = 1;

        //populate prefix
        for(let i = 1; i < n; i++){
            prefix[i] = nums[i-1] * prefix[i-1];
        }

        //populate suffix
        for(let i = n - 2; i >= 0; i--){
            suffix[i] = suffix[i+1] * nums[i+1];
        }

        //populate res
        for (let i = 0 ; i < n; i++){
            res[i] = prefix[i] * suffix[i];
        }

        return res
    }
}
