class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        int n = nums.length;
        backtrack(nums, new boolean[n], new ArrayList<>());
        return res;

    }

    private void backtrack(int[] nums, boolean [] picked, List<Integer> p){
        if (p.size() == nums.length){
            res.add(new ArrayList(p));

            return;
        }


        for(int i = 0 ; i < nums.length; i++){
            if (!picked[i]){
                picked[i] = true;
                p.add(nums[i]);

                backtrack(nums, picked, p);

                picked[i] = false;
                p.remove(p.size() - 1);
            }
        }
    }

    

    
}
