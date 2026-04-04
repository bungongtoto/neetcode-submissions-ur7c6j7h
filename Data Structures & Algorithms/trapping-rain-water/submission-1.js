class Solution {
    /**
     * @param {number[]} height
     * @return {number}
     */
    trap(height) {
        let l = 0; 
        let r = height.length - 1;
        let res = 0;

        while (l < r){
            while(height[l] < height[l+1] && l < r){
                l++;
            }

            while(height[r] < height[r - 1] && l < r) {
                r--;
            }

            if(height[l] <= height[r] && l < r){
                const temp = height[l];
                l++
                while(height[l] < temp && l < r){
                    res += temp - height[l];
                    l++;
                }
            }else if (height[l] > height[r] && l < r){
                const temp = height[r];
                r--;
                while(height[r] < temp && l < r){
                    res += temp - height[r];
                    r--;
                }
            }
        }

        return res
    }
}
