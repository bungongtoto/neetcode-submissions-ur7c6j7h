class Solution {
    private List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>());
        return res;
    }

    private void backtrack(String s,int idx,  List<String> substrings){

        if (idx >= s.length()){
            res.add(new ArrayList<>(substrings));
            return;
        }

        int iterations = s.length() - idx; 

        for (int i = 0; i < iterations; i++){
            int l = idx, r = idx + i;
            
            if (isPalindrome(s, l , r)){
              
                substrings.add(s.substring(l, r + 1));
                backtrack(s, r + 1, substrings);
                substrings.remove(substrings.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int l, int  r){

        
        
        while (l < r  && l < s.length()){
            if (s.charAt(l) != s.charAt(r)){
                return false;
            }

            l++;
            r--;
        }

        return true;
    }
}
