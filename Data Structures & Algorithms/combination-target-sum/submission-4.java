class Solution {
    private List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        dfs(nums, target,0,  0 , new ArrayList<>());
        return res;
    }


    private void dfs(int[] candidates, int target, int idx, int sum, List<Integer> comb){
        if (sum > target || idx >= candidates.length){
            return;
        }

        if (sum == target){
            res.add(new ArrayList(comb));
            return;
        }

        comb.add(candidates[idx]);

        dfs(candidates, target, idx, sum + candidates[idx], comb);

        comb.remove(comb.size() - 1);

        dfs(candidates, target, idx + 1, sum, comb);


    }
}
