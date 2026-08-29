class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();

        for (String str : strs){
            res.append(str.length());
            res.append('#');
            res.append(str);
        }

        return res.toString();
    }

    public List<String> decode(String str) {
        int l = 0, r = 0, n = str.length();
        ArrayList<String> res = new ArrayList<>();

        while (r < n ){
            while (str.charAt(r) != '#'){
                r++;
            }

            int length = Integer.parseInt(str.substring(l, r));
            r++;

            res.add(str.substring(r, r + length));

            l = r = r + length;
        }

        return res;
    }
}
