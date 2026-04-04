class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();


        for (int num : nums){
            freq.putIfAbsent(num, 0);

            freq.put(num, freq.get(num) + 1);
        }

        List<Integer> [] counts = new List[nums.length + 1];
        for (int i = 0 ; i < counts.length; i++){
            counts[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()){
            counts[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int idx = 0;

        for (int i = nums.length; i >= 0; i--){
            for (int num : counts[i]){

                res[idx] = num;
                idx++;

                if (idx == k) return res;
            }
        }

        return res;

    }
}
