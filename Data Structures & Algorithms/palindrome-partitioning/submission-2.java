class Solution {
    private List<List<String>> res;

    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        backtrack(s, 0, 0, new ArrayList());

        return res;
    }

    private void backtrack(String s, int l, int r, List<String> p){
        if (l == s.length()){
            if (!p.isEmpty()){
                res.add(new ArrayList(p));
            }

            return;
        }

        if (r == s.length()) return;

        if (isPalindrome(s, l, r)){
            p.add(s.substring(l,r + 1));
            backtrack(s, r + 1, r + 1, p);
            p.remove(p.size() - 1);
        }

        backtrack(s, l, r + 1, p);
    }

    private boolean isPalindrome(String s, int l , int r){

        while (l < r){
            if (s.charAt(l) != s.charAt(r)){
                return false;
            }

            r--;
            l++;
        }

        return true;
    }
}
