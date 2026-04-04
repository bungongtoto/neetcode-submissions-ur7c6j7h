class Solution {
    private List<List<Integer>> res;

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        backtrack(nums, new boolean[nums.length], new ArrayList<>());

        return res;
    }

    private void backtrack(int[] nums, boolean[] picked, List<Integer> perm){
        if (perm.size() == nums.length){
            if (!res.contains(perm)){
                res.add(new ArrayList(perm));
            }
            return;
        }

        for (int i = 0; i < nums.length; i++){
            if (!picked[i]){
                picked[i] = true;
                perm.add(nums[i]);
                backtrack(nums, picked, perm);
                picked[i] = false;
                perm.remove(perm.size() - 1);
            }
        }
    }
}