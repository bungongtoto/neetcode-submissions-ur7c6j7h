class Solution {
    private List<List<Integer>> res;

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        backtrack(nums, new boolean[nums.length], new ArrayList<>());
        return res;
    }

    private void backtrack(int[] nums, boolean[] pick, List<Integer> p){
        if (p.size() == nums.length && !res.contains(p)){
            res.add(new ArrayList<>(p));
            return;
        }

        for (int i = 0 ; i < nums.length; i++){
            if (!pick[i]){
                p.add(nums[i]);
                pick[i] = true;
                backtrack(nums, pick, p);
                pick[i] = false;
                p.remove(p.size() - 1);
            }
        }
    }

    
}