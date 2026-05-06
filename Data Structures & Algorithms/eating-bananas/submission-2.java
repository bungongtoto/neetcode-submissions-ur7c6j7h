class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = Arrays.stream(piles).max().getAsInt();
        int res = r;

        while (l <= r){
            int mid = l + (r - l)/2;

            int hours = 0;

            for (int b: piles){
                hours += Math.ceil((double) b / mid);
            }

            if (hours <= h){
                System.out.println(mid);
                res = Math.min(res, mid);
                r = mid - 1;
            }else if (hours > h){
                l = mid + 1;
            }
        }

        return res;
    }
}
