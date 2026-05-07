class Solution {
    private List<String> res = new ArrayList<String>();
    private String[] digitsToChar = new String[]{
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
       res = new ArrayList<>();
       if (digits.length() == 0) return res;
       backtrack(digits, 0, new StringBuilder());
       return res;
    }

    private void backtrack(String digits, int idx, StringBuilder comb){
        if (comb.length() == digits.length() ){
            res.add(comb.toString());
            return;
        }
        int index =  Character.getNumericValue(digits.charAt(idx));
        String num_chars = digitsToChar[index];

        for (char c : num_chars.toCharArray() ){
            comb.append(c);
            backtrack(digits, idx + 1, comb);
            comb.deleteCharAt(comb.length() - 1);
        }
    }

    

   
}
