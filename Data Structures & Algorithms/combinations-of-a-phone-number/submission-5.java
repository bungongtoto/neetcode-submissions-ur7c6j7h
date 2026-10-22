class Solution {
    private static final Map<Character, String> DIGIT_TO_LETTERS = Map.of(
        '1', "",
        '2', "abc",
        '3', "def",
        '4', "ghi",
        '5', "jkl",
        '6', "mno",
        '7', "pqrs",
        '8', "tuv",
        '9', "wxyz"
    );

    private List<String> res;

    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();

        if (digits.length() == 0) return res;

        backtrack(digits, 0, new StringBuilder());

        return res;
    }

    private void backtrack(String digits, int idx, StringBuilder str){
        if (idx == digits.length()){
            res.add(str.toString());
            return;
        }

        for(char c : DIGIT_TO_LETTERS.get(digits.charAt(idx)).toCharArray()){
            str.append(c);
            backtrack(digits, idx + 1, str);

            str.deleteCharAt(str.length() - 1);
        }
    }
}
