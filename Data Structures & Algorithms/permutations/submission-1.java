class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<List<Integer>> ();
        backtrack( nums, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }

    public void backtrack(int[] nums, List<Integer> perm, boolean[] pick){
        if (perm.size() == nums.length){
            res.add(new ArrayList(perm));
            return;
        }

        for (int i = 0 ; i < nums.length; i++){
            if (!pick[i]){
                pick[i] = true;
                perm.add(nums[i]);
                backtrack(nums, perm, pick);
                pick[i] = false;
                perm.remove(perm.size() - 1);
            }
        }
    }
}
