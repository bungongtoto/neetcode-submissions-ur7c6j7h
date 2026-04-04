class Solution {

    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0, l = 0;
        int minLength = Integer.MAX_VALUE;

        for (int r = 0 ; r < nums.length; r++){
            sum += nums[r];
            
            while( sum >= target){
               minLength = Math.min(minLength, r - l + 1);
               sum -= nums[l];
               l++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}