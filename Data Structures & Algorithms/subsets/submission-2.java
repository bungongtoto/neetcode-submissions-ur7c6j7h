class Solution {
   
   private List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
       backtrack(nums, 0, new ArrayList());
       return res;
    }

    private void backtrack(int[] nums,int idx, List<Integer> subset){
        res.add(new ArrayList<>(subset));

        for (int i = idx; i < nums.length; i ++ ){
            subset.add(nums[i]);
            backtrack(nums, i + 1, subset);
            subset.remove(subset.size() - 1);
        }
    }

    
}
