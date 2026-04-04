class Solution {
    /**
     * @param {number[]} nums
     * @param {number} target
     * @return {number[]}
     */
    twoSum(nums, target) {
        const prevMaps = new Map();

        for (let i = 0 ; i < nums.length; i++){
            const diff = target - nums[i];

            if (prevMaps.has(diff)){
                return [prevMaps.get(diff), i];
            }

            prevMaps.set(nums[i], i);
        }
    }
}
