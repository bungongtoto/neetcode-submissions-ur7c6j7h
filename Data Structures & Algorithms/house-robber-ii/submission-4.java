class Solution {
    private int[][] memo;
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        
        memo = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++){
            memo[i][0] = -1;
            memo[i][1] = -1;
        }
        return Math.max(dfs(nums, 1 ,0), dfs(nums,0, 1));
    }

    private int dfs(int[] nums,int flag, int i){
        if (i >= nums.length || (flag == 1 && i == nums.length - 1) ) return 0;

        if (memo[i][flag] != -1){
            return memo[i][flag];
        }

        int rob1 = dfs(nums, flag, i + 1);
        int rob2 = nums[i] + dfs(nums,flag,  i + 2);

        memo[i][flag] =  Math.max(rob1, rob2);

        return memo[i][flag];
    }
}
