class Solution {
    /**
     * @param {number[]} nums
     * @param {number} k
     * @return {number[]}
     */
    topKFrequent(nums, k) {
        let freq = {};

        //freq of elements

        for (const num of nums){
            freq[num] = (freq[num] || 0) + 1;
        }

        freq = Object.entries(freq).sort((a, b) => b[1] - a[1]);

        
        const res = []
        for (let i = 0 ; i < k; i++){
            res.push(freq[i][0]);
        }

        return res;

    }
}
