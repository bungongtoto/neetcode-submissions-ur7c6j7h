class Solution {
    /**
     * @param {string} s
     * @return {boolean}
     */
    isValid(s) {
       if (s.length === 1) return false;

        const bracket = {']' : '[', '}':'{', ')':'('};
        const stack = [];
        let r = 0, n = s.length;

        while (r < n){
            if (bracket[s[r]]){
                if (stack.pop() !== bracket[s[r]]) return false;
            }else {
                stack.push(s[r]);
            }
            r++;
        }

        return stack.length === 0;
    }
}
