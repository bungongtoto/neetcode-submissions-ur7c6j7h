class Solution {
    private List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        backtrack(n, 0, 0, new StringBuilder());
        return res;
    }

    private void backtrack(int n, int opened, int closed, StringBuilder b){
        if (closed == opened && opened == n){
            res.add(b.toString());
            return;
        }

        if (opened < n){
            b.append('(');
            backtrack(n, opened + 1, closed, b);
            b.deleteCharAt(b.length() - 1);
        }

        if (closed < opened){
            b.append(')');
            backtrack(n, opened, closed + 1, b);
            b.deleteCharAt(b.length() - 1);
        }
    }
}
