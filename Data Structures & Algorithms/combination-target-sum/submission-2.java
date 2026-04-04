class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        backtrack(nums, 0,target, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] nums, int index, int target, List<Integer> combination){
        if (target == 0) {
            res.add(new ArrayList(combination));
            return;
        }

        if (target < 0) return;

        for (int i = index ; i < nums.length; i++){
            combination.add(nums[i]);
            backtrack(nums, i ,target - nums[i], combination);
            combination.remove(combination.size() - 1);
        }
    }

   
}
