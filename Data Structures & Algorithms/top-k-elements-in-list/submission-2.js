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

        const minHeap = [];

        for (const xCount of Object.entries(freq)){
            minHeap.push(xCount);
            minHeap.sort((a,b) => b[1] - a[1] );

            if (minHeap.length > k){
                minHeap.pop()
            }
        }

        return minHeap.map(pair => pair[0])

    }
}
