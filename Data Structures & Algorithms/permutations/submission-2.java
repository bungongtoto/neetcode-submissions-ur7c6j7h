class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        backtrack(nums, new boolean[nums.length], new ArrayList<>());
        return res;
    }

    private void backtrack(int[] nums, boolean[] picked, List<Integer> perm){
        if (perm.size() == nums.length){
            res.add(new ArrayList(perm));
            return;
        }

        for (int i = 0 ; i < nums.length ; i++){
            if (!picked[i]){
                perm.add(nums[i]);
                picked[i] = true;

                backtrack(nums, picked, perm);

                perm.remove(perm.size() - 1);
                picked[i] = false;
            }
        }
    }

    
}
