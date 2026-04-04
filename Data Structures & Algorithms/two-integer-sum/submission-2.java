class Solution {
    public int[] twoSum(int[] nums, int target) {
       Map<Integer, Integer> seen = new HashMap<>();
       int [] res = new int[2];

       for (int i = 0 ; i < nums.length; i++){
        int diff = target - nums[i];
        if (seen.containsKey(diff)){
            res[0] = seen.get(diff);
            res[1] = i;
            break;
        }

        seen.put(nums[i], i );
       }

       return res;
    }
}
