class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();

        for (String token : tokens){
            if (isOperator(token)){
                String res  = String.valueOf(calculate(stack.pop(), stack.pop(), token));
                stack.push(res);
            }else {
                stack.push(token);
            }
        }

        return  Integer.parseInt(stack.pop());
    }

    private boolean isOperator(String str){
        return str.equals("+") || str.equals("-")  || str.equals("/")  || str.equals("*") ;
    }

    private int calculate(String operant1, String operant2, String operator){
        int res = 0;
        switch(operator){
            case "+":
             res =  Integer.parseInt(operant1) + Integer.parseInt(operant2);
             break;

            case "-":
             res =  Integer.parseInt(operant2) - Integer.parseInt(operant1);
             break;

            case "*":
             res =  Integer.parseInt(operant1) * Integer.parseInt(operant2);
             break;

            case "/":
             res =  Integer.parseInt(operant2) / Integer.parseInt(operant1);
             break;
        }

        System.out.println(operant1 +" "+   operant2 + " " +  operator + " " + res);

        return res;
    }
}
