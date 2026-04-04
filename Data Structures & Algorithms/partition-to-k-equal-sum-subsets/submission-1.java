class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums.length < k ) return false;
        
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
        }

        if (sum % k != 0) return false;

        int target = sum / k;

        return backtrack(nums, k , target, 0, new boolean[nums.length]);
    }

    private boolean backtrack(int[] nums, int k ,int target, int currSum, boolean[] used){
        if (k == 0) return true;

        if (currSum == target){
            return backtrack(nums, k - 1, target, 0, used);
        }

       

        for (int i = 0 ; i < nums.length; i++){
            if (used[i] || currSum + nums[i] > target ) continue;
     
            used[i] = true;
            if (backtrack(nums, k, target, currSum + nums[i], used)){
                return true;
            }
            used[i] = false;
        }

        return false;
    }
}