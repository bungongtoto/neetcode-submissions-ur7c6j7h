class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        if (n == 0 ) return new int[0];
        int[] res = new int[n];
        res[0] = 1;
        // prefix product
        for (int i = 1; i < n; i++){
            res[i] = res[i - 1] * nums[i - 1];
        }

        System.out.println(Arrays.toString(res));
        //postfix product
        int postfix = 1;

        for (int j = n - 1 ; j >= 0; j--){
            res[j] *= postfix ;
            postfix *= nums[j];
        }

        return res;
    }
}  
