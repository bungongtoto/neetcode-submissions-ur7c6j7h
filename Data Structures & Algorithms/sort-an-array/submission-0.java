class Solution {
    public int[] sortArray(int[] nums) {
        if (nums.length == 1) return nums;

        int pivot = nums.length / 2;

        return merge(sortArray(Arrays.copyOfRange(nums, 0, pivot)), sortArray(Arrays.copyOfRange(nums, pivot, nums.length)));
    }

    private int[] merge(int[] a, int[] b){
        int lengthA = a.length, lengthB = b.length;
        int [] res = new int[lengthA + lengthB];

        int la = 0, lb = 0, index = 0;

        while (la < lengthA && lb < lengthB){
            if (a[la] < b[lb]){
                res[index] = a[la];
                index++;
                la++;
            }else{
                res[index] = b[lb];
                index++;
                lb++;
            }
        }

        while (la < lengthA){
            res[index] = a[la];
            index++;
            la++;
        }

        while (lb < lengthB){
            res[index] = b[lb];
            index++;
            lb++;
        }

        return res;
    }
}