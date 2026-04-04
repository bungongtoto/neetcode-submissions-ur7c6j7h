class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        List<Integer> curr = new ArrayList<>();
        backtrack(candidates, target, curr, 0);
        return res;
    }

    public void backtrack(int[] candidates, int target, List<Integer> curr, int startIndex){
        if (target == 0){
            res.add(new ArrayList(curr));
            return;
        }

        if (target < 0 || startIndex >= candidates.length) return;

        for (int i = startIndex; i < candidates.length; i++){
            curr.add(candidates[i]);
            backtrack(candidates, target - candidates[i], curr, i + 1);
            curr.remove(curr.size() - 1);

            while(i + 1 < candidates.length && candidates[i] == candidates[i+ 1]){
                i++;
            }
        }
    }
}
