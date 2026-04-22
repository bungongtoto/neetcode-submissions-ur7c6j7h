class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] candidates, int target, int idx, List<Integer> c){
        if (target == 0){
            res.add(new ArrayList<>(c));
            return;
        }

        if (target < 0) return;

        for (int i = idx; i < candidates.length; i++){
            c.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, c);
            c.remove(c.size() - 1);

            while (i + 1 < candidates.length && candidates[i] == candidates[i+1]){
                i++;
            }
        }
    }

   
   
}
