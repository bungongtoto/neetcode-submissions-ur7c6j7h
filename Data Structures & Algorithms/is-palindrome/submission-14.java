class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();

        int l = 0, r = n - 1;

        while (l < r){
            while (l < r && !isAlpha(s.charAt(l))){
                l++;
            }

            while ( l < r && !isAlpha(s.charAt(r))){
                r--;
            }

            if ( Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))){
                return false;
            }

            l++;
            r--;
        }

        return true;
    }


    private boolean isAlpha(char c){
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' &&  c <= '9');
    }
}
