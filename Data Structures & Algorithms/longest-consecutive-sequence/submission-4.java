class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();

        int length = 0, n = nums.length;

        for (int num: nums){
            numSet.add(num);
        }

        for (int i = 0; i < n; i++){
            int len = 0;

            int num = nums[i];

            if (!numSet.contains(num - 1)){
                while (numSet.contains(num)){
                len++;
                num++;
                }

                length = Math.max(len, length);
            }
            
        }


        return length;
    }
}
