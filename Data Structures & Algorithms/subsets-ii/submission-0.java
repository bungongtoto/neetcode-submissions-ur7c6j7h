class Solution {
    private List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        res = new ArrayList<>();

        backtrack(nums, 0, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] nums, int idx , List<Integer> subset){
        if (!res.contains(subset)) {
            res.add(new ArrayList(subset));
        }

        if (idx == nums.length) return;

        
            
        subset.add(nums[idx]);
        backtrack(nums, idx + 1, subset);
        subset.remove(subset.size() - 1);
        backtrack(nums, idx + 1, subset);

        
    }
}
