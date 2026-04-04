class Solution {
    /**
     * @param {string[]} tokens
     * @return {number}
     */
    evalRPN(tokens) {
        const stack = [];
        const operators = "+-*/";

        for (let i = 0 ; i < tokens.length ; i++){
            if (operators.includes(tokens[i]) && stack.length > 1){
                stack.push(this.evaluate(stack.pop(), stack.pop(), tokens[i]));
            }else {
                stack.push(parseInt(tokens[i]))
            }
        }

        return stack.pop();
    }

    evaluate(d1, d2, operator){
        switch(operator){
            case '+':
                return parseInt(d1 + d2);  
            case '-':
                return parseInt(d2 - d1);
            case '*':
                return parseInt(d1 * d2);
            case '/':
                return parseInt(d2 / d1);
        }
    }
}
