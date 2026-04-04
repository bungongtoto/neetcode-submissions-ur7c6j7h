class Solution {
    /**
     * @param {string} s
     * @param {string} t
     * @return {boolean}
     */
    isAnagram(s, t) {
        //edge case if both are not of thesame length
        if (s.length !== t.length){
            return false;
        }

        const countS = {};
        const countT = {};

        //count the occurrance of each letter in both S and T
        for (let i = 0 ; i < s.length ; i++){
            countS[s[i]] = (countS[s[i]] || 0) + 1;
            countT[t[i]] = (countT[t[i]] || 0) + 1;
        }

        console.log(countS, countT);

        //return false if any character count are not equal

        for (const key in countS){
            if(countS[key] !== countT[key]){
                return false;
            }
        }

        return true;


    }
}
