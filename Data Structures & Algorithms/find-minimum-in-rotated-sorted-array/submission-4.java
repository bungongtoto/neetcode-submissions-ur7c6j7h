class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0 , r = n - 1;
        int res = nums[0];

        while (l <= r ){
            if (nums[r] > nums[l]){
                res = Math.min(nums[l], res);
                break;
            }

            int mid = l + (r - l ) / 2;

            res = Math.min(res, nums[mid]);
            if (nums[mid] >= nums[l]){
                l = mid + 1;
            }else{
                r = mid - 1;
            }

        }

        return res;
    }
}
