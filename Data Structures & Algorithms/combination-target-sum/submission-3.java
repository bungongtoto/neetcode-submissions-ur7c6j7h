class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        backtrack(nums, 0, target, new ArrayList<>());
        return res;
    }

    
    private void backtrack(int[] nums,int idx, int target, List<Integer> c){
        if (target == 0){
            res.add(new ArrayList<>(c));
            return;
        }

        if (target < 0) return;

        for (int i = idx; i < nums.length; i++){
            c.add(nums[i]);
            backtrack(nums, i, target - nums[i], c);
            c.remove(c.size() - 1);
        }
    }
   
}
