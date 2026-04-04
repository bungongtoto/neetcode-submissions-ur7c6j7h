class Solution {

    binarySearch(l , r, nums, target){
        if (l > r) return -1;
        let m = l + Math.floor((r - l) / 2);
        if (nums[m] === target) return m;

        return (nums[m] < target) ?  this.binarySearch(m + 1, r, nums, target) :
        this.binarySearch(l, m - 1, nums, target);
    }
    /**
     * @param {number[]} nums
     * @param {number} target
     * @return {number}
     */
    search(nums, target) {
        
        return this.binarySearch(0, nums.length - 1, nums, target);
    }
}
