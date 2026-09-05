class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        if (s1.length() > s2.length()) return false;

        for (int i = 0 ; i < s1.length(); i++){
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        int matches  = 0;

        for (int i = 0 ; i < 26; i++){
            if (freq1[i] == freq2[i]){
                matches++;
            }
        }

        if (matches == 26) return true;

        int l = 0 ,  r = s1.length();

        while (r < s2.length() ){
            int index = s2.charAt(l) - 'a';
            if (freq2[index] == freq1[index]){
                matches --;
            }

            freq2[index]--;

            if (freq2[index] == freq1[index]){
                matches ++;
            }
            l++;

            int indexR = s2.charAt(r) - 'a';
            if (freq2[indexR] == freq1[indexR]){
                matches --;
            }

            freq2[indexR]++;

            if (freq2[indexR] == freq1[indexR]){
                matches ++;
            }

            r++;

            if (matches == 26) return true;

        }


        return false;


    }
}
