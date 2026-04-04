class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;

        for (int i = 0 ; i < n ; i++){
            int sum = 1;

            for (int j = i + 1 ; j < n ; j++){
                if (nums[j] == nums[i]) sum++;
            }

            if (sum > (n / 2)) return nums[i];
        }

        return 0;
    }
}