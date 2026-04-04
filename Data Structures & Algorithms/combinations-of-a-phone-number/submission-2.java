class Solution {
    private List<String> res = new ArrayList<String>();
    private String[] digitsToChar = new String[]{
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return res;
        backtrack(digits, 0, new StringBuilder());

        return res;
    }

    private void backtrack(String digits, int i, StringBuilder stack){
        if (stack.length() == digits.length()){
            res.add(stack.toString());
            return;
        }

        if (i >= digits.length()) return;

        String chars = digitsToChar[digits.charAt(i) - '0'];

        for (char c : chars.toCharArray()){
            stack.append(c);
            backtrack(digits, i + 1,stack );
            stack.deleteCharAt(stack.length() - 1);
        }
    }
}
