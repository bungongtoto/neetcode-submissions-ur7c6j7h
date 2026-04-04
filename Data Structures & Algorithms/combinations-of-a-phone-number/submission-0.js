class Solution {
    /**
     * @param {string} digits
     * @return {string[]}
     */
    letterCombinations(digits) {
        if (digits.length === 0) return [];
        let res = [""];
        const digitsChar = {
            2: 'abc',
            3: 'def',
            4: 'ghi',
            5: 'jkl',
            6: 'mno',
            7: 'qprs',
            8: 'tuv',
            9: 'wxyz'
        }

        for (const d of digits){
            const temp = []
            for (let curStr of res){
                for (const c of digitsChar[d]){
                   
                    temp.push(curStr+c)
                }
            }
            res = temp;
        }

        return res;
    }
}
