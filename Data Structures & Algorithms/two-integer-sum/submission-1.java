class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] res = null;
        HashMap<Integer, Integer> seen = new HashMap();

        for (int index = 0 ; index < nums.length ; index++){
            int diff = target - nums[index];
            if (seen.containsKey(diff)){
                res = new int[]{seen.get(diff), index};
                break;
            }else {
                seen.put(nums[index], index);
            }
        }

        return res;
    }
}
