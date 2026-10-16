class Solution {
    private List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>());

        return res;
    }

    private void dfs (int[] nums, int idx, List<Integer> subset){
        if (idx >= nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }
        
        subset.add(nums[idx]);

        dfs(nums, idx + 1, subset);

        subset.remove(subset.size() - 1);

        dfs(nums, idx + 1, subset);
    }
}
