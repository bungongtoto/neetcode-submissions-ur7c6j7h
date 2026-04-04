class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int [] res = new int[n];

        res[0] = 1;

        for (int index = 1; index < n ; index++){
            res[index] = nums[index - 1] * res[index - 1];
        }

        int postfix = 1;

        for (int index = n - 1; index >= 0 ; index-- ){
            res[index] *= postfix;
            postfix *= nums[index];
        }

        return res;
    }
}  
