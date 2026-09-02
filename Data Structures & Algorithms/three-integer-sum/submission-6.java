class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // sort nums
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        int n = nums.length;

        for (int i = 0 ; i < n ; i++){

            if (nums[i] > 0) break;

            int l = i + 1, r = n - 1;

            while (l < r){
                int sum = nums[i] + nums[l] + nums[r];

                if (sum < 0 ){
                    l++;
                }else if (sum > 0){
                    r--;
                }else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;

                    while (l < n && nums[l] == nums[l-1] ){
                        l++;
                    }
                }
            }

            while (i + 1 < n && nums[i] == nums[i+1] ){
                i++;
            }
        }

        return res;

    }
}
