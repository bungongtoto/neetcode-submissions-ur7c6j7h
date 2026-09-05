class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> freq = new HashMap<>();
        int n = s.length();

        int l = 0, r = 0, maxf = 0;

        int res = 0;

        while (r < n){
            freq.put(s.charAt(r), freq.getOrDefault(s.charAt(r), 0) + 1);
            maxf = Math.max(maxf, freq.get(s.charAt(r)));


            while ((r + 1 - l) - maxf > k){
                freq.put(s.charAt(l), freq.get(s.charAt(l)) - 1);
                l++;
            }

            res = Math.max((r + 1 - l), res);
            r++;
        }


        return res;
    }
}
