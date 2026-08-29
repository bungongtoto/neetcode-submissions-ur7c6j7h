class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> freq = new HashMap<>();

        int[] res = new int[k];

        for (int num: nums){
           if (freq.containsKey(num)){
                freq.put(num, freq.get(num) + 1);
           }else{
                freq.put(num, 1);
           }
        }
        //store in an Array of List with array length max freq
        List<Integer>[] cFreq = new List[nums.length + 1];

        for (int i = 0 ; i < nums.length + 1; i++){
            cFreq[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry: freq.entrySet()){
            cFreq[entry.getValue()].add(entry.getKey());
        }
        // go through the array and get the k most frequent elements
        int n = cFreq.length - 1;
        int r = 0;

        while (k > 0 && n >= 0 ){
            for (Integer num : cFreq[n]){
                res[r] = num;
                r++;
                k--;

                if (k <= 0 ) break;
            }
            n--;
        }

        return res;

    }
}
