class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1 , r = Arrays.stream(piles).max().getAsInt();
        int k = r;
        while (l <= r){
           int mid = ((r - l) / 2) + l;

            int totalHours = 0;

            for (int pile : piles){
                totalHours += (int) Math.ceil((double) pile / mid);
            }

            if (totalHours <= h){
                k = Math.min(k, mid);
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }

        return k;
    }
}
