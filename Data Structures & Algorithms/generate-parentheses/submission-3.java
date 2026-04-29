class Solution {
    List<String> res ;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        backtrack(n, 0 , 0, new StringBuilder());
        return res;
    }

    private void backtrack(int n , int openN, int closedN, StringBuilder bracket){
        if (openN == n && closedN == openN){
            res.add(bracket.toString());
            return;
        }

        if (openN < n){
            bracket.append('(');
            backtrack(n, openN + 1, closedN, bracket);
            bracket.deleteCharAt(bracket.length() - 1);
        }

        if (closedN < openN){
            bracket.append(')');
            backtrack(n, openN, closedN + 1, bracket);
            bracket.deleteCharAt(bracket.length() - 1);
        }
    }

    
}
