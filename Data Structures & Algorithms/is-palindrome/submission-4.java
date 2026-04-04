class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
       int l = 0, r = s.length() - 1;

       while(l <= r) {
        while ( l < n && !alphaNum(s.charAt(l))){
            l++;
        }


        while (r > 0 && !alphaNum(s.charAt(r))){
            r--;
        }

        if (l < n && r > 0 && Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))){
            System.out.println(l + ":  " + s.charAt(l) + " "  + r + ": " + s.charAt(r));
            return false;
        }

        l++;
        r--;
       }

       return true;
    }

    private boolean alphaNum(char c){
        return (Character.isAlphabetic(c) || Character.isDigit(c));
    }
}
