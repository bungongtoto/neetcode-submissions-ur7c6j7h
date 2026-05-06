class Solution {
    private List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        backtrack(s, 0, new ArrayList());
        return res;
    }

    private void backtrack(String s, int idx , List<String> p){
        if (idx == s.length()) {
           if (!p.isEmpty()){
             res.add(new ArrayList(p));
           }
            return;
        }

        for (int i = idx; i < s.length(); i++){
            if (isPalindrome(s,idx, i)){
                p.add(s.substring(idx, i + 1));
                backtrack(s, i + 1, p);
                p.remove(p.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int l, int r){
        while (l <= r){
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }

        return true;
    }

    
}
