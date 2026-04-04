class Solution {
    private List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();

        backtrack(n, k , 1, new ArrayList<>());
        return res;
    }

    private void backtrack(int n , int k,int start, List<Integer> combination){
        if (combination.size() == k){
            res.add(new ArrayList(combination));
            return;
        }

        if (start > n) return;


        for (int i = start ; i <= n ; i++){
            combination.add(i);
            backtrack(n, k , i+1, combination );
            combination.remove(combination.size() - 1);
        }
    }
}