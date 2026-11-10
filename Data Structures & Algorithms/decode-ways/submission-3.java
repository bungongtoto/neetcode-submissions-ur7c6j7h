class Solution {
    private int[] memo;
    public int numDecodings(String s) {
        memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return dfs(s,0);
    }

    private int dfs(String s, int idx){
        if (idx == s.length()) return 1;

        if (idx > s.length() || s.charAt(idx) == '0') return 0;

        if (memo[idx] != -1) return memo[idx];

        int count1 = dfs(s, idx + 1);
        if (idx + 2 > s.length() || Character.getNumericValue(s.charAt(idx)) > 2 || (Character.getNumericValue(s.charAt(idx)) == 2 &&  Character.getNumericValue(s.charAt(idx + 1)) > 6)){          memo[idx] = count1;
            return memo[idx];
        }
        int count2 = dfs(s, idx + 2);

        memo[idx] = count1 + count2;

        return memo[idx];
    }
}
