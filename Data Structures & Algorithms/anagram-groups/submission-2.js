class Solution {
    /**
     * @param {string[]} strs
     * @return {string[][]}
     */
    groupAnagrams(strs) {
        const res = {};
        
        for (const str of strs){
            const count = new Array(26).fill(0);

            for (const c of str){
                count[c.charCodeAt(0)- 'a'.charCodeAt(0)]++;
            }

            const key = count.join(",");

            if (!res[key]){
                res[key] = [];
            }

            res[key].push(str);
        }

        return Object.values(res);
    }
}
