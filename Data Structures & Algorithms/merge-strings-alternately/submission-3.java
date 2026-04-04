class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder merge = new StringBuilder();

        int length1 = word1.length(), length2 = word2.length();

        int l1 = 0, l2 = 0;

        while( l1 < length1 || l2 < length2){
           if (l1 < length1) merge.append(word1.charAt(l1++));

           if (l2 < length2) merge.append(word2.charAt(l2++));
        }

        return merge.toString();
    }
}