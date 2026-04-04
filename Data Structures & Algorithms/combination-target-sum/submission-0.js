class Solution {
    /**
     * @param {number[]} nums
     * @param {number} target
     * @returns {number[][]}
     */
    combinationSum(nums, target) {
        const ans = [];
        const curr = [];
        this.backtrack(nums, target, ans, curr, 0);
        return ans;
    }

    backtrack(nums, target, ans, curr, index){
        if (target === 0){
            ans.push([...curr]);
        }else if (target < 0 || index >= nums.length){
            return;
        }else {
            curr.push(nums[index]);
            this.backtrack(nums, target - nums[index], ans, curr, index);

            curr.pop();
            this.backtrack(nums, target, ans, curr, index + 1)
        }
    }
}
