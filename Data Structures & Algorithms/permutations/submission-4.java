class Solution {
    private List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        dfs(nums, new boolean[nums.length], new ArrayList<>());

        return res;
    }

    private void dfs(int[] nums, boolean[] seen, List<Integer> pem){
        if (pem.size() == nums.length){
            res.add(new ArrayList(pem));
            return;
        }


        for (int i = 0 ; i < nums.length; i++){
            if (seen[i] == false){
                seen[i] = true;
                pem.add(nums[i]);
                dfs(nums, seen, pem);
                pem.remove(pem.size() - 1);
                seen[i] = false;
            }
        }
    }
}
