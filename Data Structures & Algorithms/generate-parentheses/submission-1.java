class Solution {
    List<String> res ;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<String>();
        backtrack(0, 0, n , new StringBuilder());

        return res;
    }

    public void backtrack(int openN, int closedN, int n, StringBuilder stack){
        if (openN == closedN && openN == n){
            res.add(stack.toString());
            return;
        }

        if (openN < n){
            stack.append('(');
            backtrack(openN + 1, closedN, n , stack);
            stack.deleteCharAt(stack.length() - 1);
        }

        if (openN > closedN){
            stack.append(')');
            backtrack(openN , closedN + 1, n , stack);
            stack.deleteCharAt(stack.length() - 1);
        }
    }
}
