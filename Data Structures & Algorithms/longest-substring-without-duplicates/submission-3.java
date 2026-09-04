class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();

        int n = s.length();

        int l = 0 , r = 0;

        int maxLength = 0;

        while (r < n){
            while (seen.contains(s.charAt(r))){
                seen.remove(s.charAt(l));
                l++;
            }

            seen.add(s.charAt(r));

            maxLength = Math.max((r - l + 1), maxLength);
            r++;
        }

        return maxLength;
    }
}
