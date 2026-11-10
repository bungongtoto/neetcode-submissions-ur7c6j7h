class Solution {
    public int countSubstrings(String s) {
        int res = 0;

        for (int i = 0 ; i < s.length(); i++){
            // odd 
            int l = i, r = i;

            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                res++;
                l--;
                r++;
            }
            //even
            l = i;
            r = l + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                res++;
                l--;
                r++;
            }
        }

        return res;
    }
}
