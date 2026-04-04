class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();

        Arrays.sort(candidates);
        backtrack(candidates, 0, target, new ArrayList<>());

        return res;
    }

    private void backtrack(int[] candidates, int index, int target, List<Integer> combination){
        if (target == 0 ){
            res.add(new ArrayList(combination));
            return;
        }

        //if (index > 0  && index < candidates.length && candidates[index - 1] == candidates[index]) return;

        if (target < 0) return;

        for (int i = index; i < candidates.length; i++){
            combination.add(candidates[i]);
            backtrack(candidates, i + 1, target - candidates[i], combination);
            combination.remove(combination.size() - 1);

            while(i + 1 < candidates.length && candidates[i] == candidates[i+1]){
                i++;
            }
        }
    }

   
}
