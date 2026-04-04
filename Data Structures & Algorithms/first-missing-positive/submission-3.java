class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        int i = 0;

        while (i < n){
            if (nums[i] <= 0 || nums[i] > n){
                i++;
                continue;
            }

            int index = nums[i] - 1;

            if (nums[i] != nums[index]){
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
            }else {
                i++;
            }
        }


        for (int idx  = 0 ; idx < n; idx++){
            if (nums[idx] != idx + 1){
                return idx + 1;
            }
        }

        return n + 1;
        
    }
}