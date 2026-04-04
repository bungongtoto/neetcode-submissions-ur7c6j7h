class Solution {
    /**
     * @param {number[]} nums
     * @return {boolean}
     */
    hasDuplicate(nums) {
        const freq = {};

        for (let i = 0 ; i < nums.length; i++){
            freq[nums[i]] = (freq[nums[i]] || 0) + 1
        }

        console.log(freq);

        for (const count of Object.values(freq)){
            if (count > 1){
                return true;
            }
        }

        return false;
    }
}
