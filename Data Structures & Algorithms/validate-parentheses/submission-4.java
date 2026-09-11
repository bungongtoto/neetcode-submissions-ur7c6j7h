class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> brackets = Map.of (
            '{','}',
            '(', ')',
            '[',']'
        );


        Deque<Character> stack = new ArrayDeque<>();

        for (char b : s.toCharArray()){
            if (brackets.containsKey(b)){
                stack.push(b);
            }else {
                if (stack.isEmpty() || brackets.get(stack.peek()) != b ) return false;

                stack.pop();
            }
        }

        return stack.isEmpty() ? true : false;
    }
}
