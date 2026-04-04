class Solution {
    private List<String> res = new ArrayList<String>();
    private String[] digitsToChar = new String[]{
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return res;
      backtrack(digits, 0 , new StringBuilder());

      return res;
    }

    private void backtrack(String digits, int idx, StringBuilder combination){
        if (idx == digits.length()){
            res.add(combination.toString());
            return;
        }

        String characters = digitsToChar[Character.getNumericValue(digits.charAt(idx))];

        for (char character : characters.toCharArray()){
            combination.append(character);

            backtrack(digits, idx + 1, combination);
            combination.deleteCharAt(combination.length() - 1);
        }
    }

   
}
