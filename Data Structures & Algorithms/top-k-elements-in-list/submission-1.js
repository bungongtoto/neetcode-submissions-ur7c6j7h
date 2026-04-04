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

        
        return freq.slice(0, k).map(pair => pair[0]);

    }
}
