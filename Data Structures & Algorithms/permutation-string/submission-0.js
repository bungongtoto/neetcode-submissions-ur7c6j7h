class Solution {
    /**
     * @param {string} s1
     * @param {string} s2
     * @return {boolean}
     */
    checkInclusion(s1, s2) {
        if (s1.length > s2.length) {
            return false;
        }

        
        let countS1 = new Array(26).fill(0);
        let countS2 = new Array(26).fill(0);

        //counting s1 and s2 char occurrance
        for(let i = 0 ; i < s1.length ; i++){
            countS1[s1.charCodeAt(i) - 97]++;
            countS2[s2.charCodeAt(i) - 97]++;
        }

        // counting matches
        let matches = 0;
        for(let i = 0 ; i < 26; i++){
            if (countS1[i] === countS2[i]){
                matches++;
            }
        }

        //sliding window with the length of s1
        let l = 0;
        for (let r = s1.length; r < s2.length ; r++){
            if (matches === 26){
                return true;
            }

            let index = s2.charCodeAt(r) - 97;
            countS2[index]++;
            if (countS1[index] === countS2[index]){
                matches++;
            }else if (countS1[index] + 1 === countS2[index]){
                matches--;
            }

            index = s2.charCodeAt(l) - 97;
            countS2[index]--;
            if(countS1[index] === countS2[index]){
                matches++;
            }else if (countS1[index] - 1 === countS2[index]){
                matches--;
            }

            l++

        }

        return matches === 26;
    }
}
