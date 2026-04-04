class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

       Map<String, List<String>> groupAnagrams = new HashMap<>();

       for (String str : strs){
            int[] freq = new int[26];
            for (int i = 0 ; i < str.length(); i++){
                freq[str.charAt(i) - 'a']++;
            }

            String key = Arrays.toString(freq);

            groupAnagrams.putIfAbsent(key, new ArrayList<>());

            groupAnagrams.get(key).add(str);
       }

       List<List<String>> res = new ArrayList<>();

       for (Map.Entry<String, List<String>> entry : groupAnagrams.entrySet()){
            res.add(entry.getValue());
       }

       return res;
    }
}
