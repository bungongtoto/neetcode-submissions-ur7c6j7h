class Solution {
    private List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        backtrack(n, 1, k, new ArrayList<>());

        return res;
    }

    private void backtrack(int n , int cur, int k , List<Integer> c){
        if (c.size() == k){
            res.add(new ArrayList<>(c));
            return;
        }

        for (int i = cur; i <= n; i++){
            c.add(i);
            backtrack(n, i + 1, k, c);
            c.remove(c.size() - 1);
        }
    }

    
}