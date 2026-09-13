class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String s : tokens){
            if (isOperator(s)){
                int res = eval(stack.pop(), stack.pop(), s);
                stack.push(res);
            }else {
                stack.push(Integer.parseInt(s));
            }
        }

        return stack.pop();
    }

    private boolean isOperator(String s){
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    private int eval(int f, int s, String p){
       if (p.equals("+")){
            return f + s;
       }else if (p.equals("*")){
            return f * s;
       }else if (p.equals("-")){
            return s - f;
       }else if (p.equals("/")) {
            return s / f;
       }

       return 0;
    }
}
