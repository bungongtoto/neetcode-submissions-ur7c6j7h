class Solution {
    int ROWS;
    int COLS;
    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;

        for (int r = 0 ; r < ROWS; r++){
            for (int c = 0 ; c < COLS; c++){
                if (dfs(board, word, 0, r, c)){
                    return true;
                }
            }
        }


        return false;

    }

    private boolean dfs(char[][] board, String word, int i , int r, int c){
        if (i == word.length()){
            return true;
        }

        if (r < 0 || c < 0 || r == ROWS || c == COLS || board[r][c] == '#' || board[r][c] != word.charAt(i)){
            return false;
        }

        board[r][c] = '#';

        boolean res = dfs(board, word, i + 1, r + 1, c ) ||
                    dfs(board, word, i + 1, r - 1, c ) ||
                    dfs(board, word, i + 1, r , c + 1 ) ||
                    dfs(board, word, i + 1, r , c - 1 ) ;

        board[r][c] = word.charAt(i);

        return res;
    }
}
