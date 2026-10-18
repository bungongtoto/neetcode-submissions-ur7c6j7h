class Solution {

    private List<List<Integer>> res;
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, 0, new ArrayList<>());

        return res;
    }

    private void dfs(int[] candidates, int target, int idx, int total,List<Integer> cur){
        if (total == target){
            res.add(new ArrayList(cur));
            return;
        }

        if (total > target || idx == candidates.length) return;


        cur.add(candidates[idx]);

        dfs(candidates, target, idx + 1, total + candidates[idx], cur );

        cur.remove(cur.size() - 1);


        while (idx + 1 < candidates.length && candidates[idx] == candidates[idx + 1]){
            idx++;
        }

        dfs(candidates, target, idx + 1, total, cur );
    }

    
}
