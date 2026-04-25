class Solution {
    private List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
       res = new ArrayList<>();
       backtrack(nums, 0, new ArrayList());
       return res;
    }

    private void backtrack(int[] nums, int idx, List<Integer> s){
        if (!res.contains(s)){
            res.add(new ArrayList<>(s));
        }

        for (int i = idx; i < nums.length; i++){
            s.add(nums[i]);
            backtrack(nums, i + 1, s);
            s.remove(s.size() - 1);
        }
    }

    
}
