class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupedWords = new HashMap<>();

        for (String str: strs){
            int[] freq = new int[26];

            for (char c : str.toCharArray()){
                freq[c - 'a']++;
            }

            String key = Arrays.toString(freq);

            groupedWords.computeIfAbsent(key, k -> new ArrayList<>());

            groupedWords.get(key).add(str);

        }

        ArrayList<List<String>> res = new ArrayList<>();

        for (String key: groupedWords.keySet()){
            res.add(groupedWords.get(key));
        }

        return res;
    }
}
