class Solution {
    public boolean isAnagram(String s, String t) {
        //edge case: if s and t are not same length
        if (s.length() != t.length()) return false;

        // frequecy of characters in s and t
        Map<Character, Long> freqS = new HashMap<>();
        Map<Character, Long> freqT = new HashMap<>();

        for (int i = 0 ; i < s.length(); i++){
            freqS.putIfAbsent(s.charAt(i), 0L);
            freqT.putIfAbsent(t.charAt(i), 0L);

            freqS.put(s.charAt(i), freqS.get(s.charAt(i)) + 1);
            freqT.put(t.charAt(i), freqT.get(t.charAt(i)) + 1);
        }

        for (Map.Entry<Character, Long> entry : freqS.entrySet()){
            if (freqT.containsKey(entry.getKey())){
                if (!freqT.get(entry.getKey()).equals(entry.getValue())) return false;
            }else {
                return false;
            }
        }

        return true;

        //return freqS.equals(freqT);


    }
}
