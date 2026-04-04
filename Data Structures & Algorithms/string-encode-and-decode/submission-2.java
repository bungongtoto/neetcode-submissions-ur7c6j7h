class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();

        for (String str : strs){
            res.append(str.length()).append('#').append(str);
        } 

        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();

        int left = 0;
        
        while( left <str.length()){
            int current = left;

            while (str.charAt(current) != '#'){
                current++;
            }

            int length =  Integer.parseInt(str.substring(left, current));

            left = current + 1;
            current = left + length;

            res.add(str.substring(left, current));

            left = current;

        }

        return res;
    }
}
