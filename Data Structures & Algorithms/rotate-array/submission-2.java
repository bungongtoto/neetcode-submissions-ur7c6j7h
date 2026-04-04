class Solution {
    // public void rotate(int[] nums, int k) {

    //     int n = nums.length;
    //     k %= n;

    //     while (k > 0){
    //         int temp = nums[n - 1];

    //         for (int i = n - 1; i > 0 ; i--){
    //             nums[i] = nums[i - 1];
    //         }

    //         nums[0] = temp;
    //         k--;
    //     }

        
    // }

    public void rotate(int[] nums, int k){
        int n = nums.length;
        k %= n;

        reverse(nums, 0 , n -1);
        reverse(nums,0 , k-1);
        reverse(nums, k, n-1);
    }


    private void reverse(int[] nums, int l, int r){
        while (l < r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;

            l++;
            r--;
        }
    }
}