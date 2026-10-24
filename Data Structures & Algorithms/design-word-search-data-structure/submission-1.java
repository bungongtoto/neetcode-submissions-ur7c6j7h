class TrieNode{
    TrieNode[] children = new TrieNode[26];
    boolean endWord = false;
}

class WordDictionary {

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;

        for (char c : word.toCharArray()){
            int i = c - 'a';

            if (cur.children[i] == null){
                cur.children[i] = new TrieNode();
            }

            cur = cur.children[i];
        }

        cur.endWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int i, TrieNode cur){
        if (cur == null) return false;

        if (i == word.length()) return cur.endWord;

        if (word.charAt(i) == '.'){
            boolean w = false;
            for (TrieNode node : cur.children){
                w = w || dfs(word, i + 1, node);
            }

            return w;
        } 
        
        if ( cur.children[word.charAt(i) - 'a'] == null) {
            return false;
        }
            
        
        return dfs(word, i + 1, cur.children[word.charAt(i) - 'a']);


    }
}
