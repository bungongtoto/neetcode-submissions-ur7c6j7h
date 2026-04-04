class Solution {
    public int longestConsecutive(int[] nums) {
        int longest = 0;
        Set<Integer> numsSet = new HashSet<>();

        for (int num : nums){
            numsSet.add(num);
        }

        for (int i = 0 ; i < nums.length; i++){
            int num = nums[i];
            int length = 1;
            while (numsSet.contains(num + 1)){
                num++;
                length++;
            }

            longest = Math.max(longest, length);
        }

        return longest;
    }
}
