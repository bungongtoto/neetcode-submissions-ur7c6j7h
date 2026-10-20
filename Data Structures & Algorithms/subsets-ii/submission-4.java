class Solution {
    private List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>());
        return res;

    }

    private void backtrack(int[] nums, int idx, List<Integer> sub){
        if (idx == nums.length){
            res.add(new ArrayList(sub));
            return;
        }

        sub.add(nums[idx]);
        backtrack(nums, idx + 1, sub);

        sub.remove(sub.size() - 1);
        while (idx + 1 < nums.length && nums[idx] == nums[idx + 1]){
            idx ++;
        }

        backtrack(nums, idx + 1, sub);
    }
}
