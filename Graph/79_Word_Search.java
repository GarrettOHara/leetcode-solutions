class Solution {
    public boolean exist(char[][] board, String word) {
        
        /* SIMPLE LOOP TO CHECK EVERY NODE */
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                
                /* PERFROM DFS ON NODE */
                if(DFS(board, word, 0, i , j))
                    return true;
                
            }
        }
        return false;
    }
    
    private boolean DFS(char[][]board, String word, int index, int i, int j){
        
        /* FOUND WORD */
        if(index==word.length())return true;
        
        /* DISQUALIFY FROM TRAVERSAL */
        if(i<0||j<0||i>=board.length||j>=board[0].length||board[i][j]!=word.charAt(index))
            return false;
        
        /* MARK AS VISITED */
        board[i][j] = '!';
        
        /* EXPLORE POSSIBLE DIRECTIONS */
        boolean exists = 
            DFS(board, word, index+1, i+1, j) ||
            DFS(board, word, index+1, i-1, j) ||
            DFS(board, word, index+1, i, j+1) ||
            DFS(board, word, index+1, i, j-1);
        
        /* SET WORD BACK */
        board[i][j] = word.charAt(index);
        
        /* RETURN EXPLORATION RESULT */
        return exists;
    }
}
