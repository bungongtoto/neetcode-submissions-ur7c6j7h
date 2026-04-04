class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;

        for (int i = 0 ; i < nums.length; i++){
            int sum = 0;
            int idx = i;
            while(idx < nums.length && sum < target){
                sum += nums[idx];
                idx++;
            }

            if (sum >= target){
                minLength = Math.min(minLength, idx - i);
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}