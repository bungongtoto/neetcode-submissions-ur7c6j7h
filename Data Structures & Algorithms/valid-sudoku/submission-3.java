class Solution {
    public boolean isValidSudoku(char[][] board) {
        // check validity of rows
        for (int r = 0 ; r < 9 ; r++){
            Set<Character> rSeen = new HashSet<>();

            for (int c = 0 ; c < 9; c++ ){
                if (board[r][c] != '.' && rSeen.contains(board[r][c])){
                    return false;
                }else if (board[r][c] != '.'){
                    rSeen.add(board[r][c]);
                }
            }
        }
        // check validity of cols
        for (int c = 0 ; c < 9 ; c++){
            Set<Character> cSeen = new HashSet<>();

            for (int r = 0 ; r < 9; r++ ){
                if (board[r][c] != '.' && cSeen.contains(board[r][c])){
                    return false;
                }else if (board[r][c] != '.'){
                    cSeen.add(board[r][c]);
                }
            }
        }
        // check validity of 3 x 3 sub boxes

        for (int block = 0 ; block <  9; block++){
            int startRow = (block / 3) * 3;
            int startCol = (block % 3) * 3;

            Set<Character> bSeen = new HashSet<>();

            for (int i = 0 ; i < 9; i++){
                int r = startRow + (i / 3);
                int c = startCol + (i % 3);

                 if (board[r][c] != '.' && bSeen.contains(board[r][c])){
                    return false;
                }else if (board[r][c] != '.'){
                    bSeen.add(board[r][c]);
                }

            }
        }


        return true;
    }
}
