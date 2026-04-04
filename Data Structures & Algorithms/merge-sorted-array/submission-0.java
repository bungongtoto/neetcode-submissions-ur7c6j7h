class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx = nums1.length - 1;

        int l2 = n - 1, l1 = m - 1;

        while (l2 >= 0 && l1 >= 0){
            if (nums1[l1] > nums2[l2]){
                nums1[idx] = nums1[l1];
                l1--;
                idx--;
            }else{
                nums1[idx] = nums2[l2];
                l2--;
                idx--;
            }
        }

        while(l1 >= 0){
            nums1[idx] = nums1[l1];
            l1--;
            idx--;
        }

        while(l2 >= 0){
            nums1[idx] = nums2[l2];
            l2--;
            idx--;
        }

    }
}