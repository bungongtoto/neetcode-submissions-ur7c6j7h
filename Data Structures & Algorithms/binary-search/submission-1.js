class Solution {

    // binarySearch(l , r, nums, target){
    //     if (l > r) return -1;
    //     let m = l + Math.floor((r - l) / 2);
    //     if (nums[m] === target) return m;

    //     return (nums[m] < target) ?  this.binarySearch(m + 1, r, nums, target) :
    //     this.binarySearch(l, m - 1, nums, target);
    // }
    /**
     * @param {number[]} nums
     * @param {number} target
     * @return {number}
     */
    search(nums, target) {
        let l = 0 , r = nums.length - 1;

        while (l <= r){
            const m = l + Math.floor((r - l )/ 2);

            if(nums[m] > target){
                r = m - 1;
            }else if (nums[m] < target){
                l = m + 1;
            }else {
                return m;
            }
        }

        return -1;
        // return this.binarySearch(0, nums.length - 1, nums, target);
    }
}
