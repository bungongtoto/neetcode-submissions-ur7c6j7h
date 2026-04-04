class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) return strs[0];

        Arrays.sort(strs, (a, b) -> a.length() - b.length());

        int r = 0;
        boolean stop = false;
        for (int i = 0 ; i < strs[0].length() ; i++ ){
            for (int j = 1; j < strs.length; j++ ){
                if ( strs[0].charAt(i) != strs[j].charAt(i)){
                    stop = true;
                    break;
                }
            }

            if (stop){
                break;
            }

            r = i + 1;
        }

        if (r == 0) return "";

        return strs[0].substring(0, r);
    }
}