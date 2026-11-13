class Solution {
    private int[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return dfs(s,wordDict,0);
    }

    private boolean dfs(String s, List<String> wordDict, int i){
        if (i == s.length()){
            return true;
        }

        if (memo[i] != -1) {
            return memo[i] == 1;
        }

        boolean match = false;

        for (String word : wordDict){
            int len = i + word.length();

            if (len > s.length()) {
                continue;
            }
            String sub = s.substring(i, i + word.length());

            if (sub.equals(word)){
                match = match || dfs(s, wordDict, i + word.length());
            }
        }

        memo[i] = match ? 1 : 0;

        return memo[i] == 1;
    }
}
