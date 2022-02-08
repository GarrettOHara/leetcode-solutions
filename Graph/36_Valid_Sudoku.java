class Solution {
    public boolean isValidSudoku(char[][] board) {
        /* SHORT CIRCUIT EVALUATION SPEEDS THIS ALGORITHM UP A LOT */
//        /* VALIDATE ROWS */
//         boolean rows = rows(board, 0);
        
//         /* VALIDATE COLUMNS */
//         boolean columns = cols(board,0);
        
//         /* VALIDATE BOXES */
//         boolean boxes = boxes(board,0,0);
            
        // return rows && columns && boxes;
        return rows(board, 0) && cols(board,0) && boxes(board,0,0);
    }
    
    private boolean rows(char[][]board,int start){
        /* BASE CASE */
        if(start >= board.length) 
            return true;
        
        /* KEEP TRACK OF DUPLICATES (COULD USE SIMPLE ARR AS WELL) */
        Set<Character>set = new HashSet<>();
        
        /* ITERATE THROUGHT SECTION */
        for(int i = 0; i < board.length; i++){
            char tmp = board[start][i];
            
            /* CHECK VALUES */
            if(tmp=='.' || set.add(tmp))
                continue;
            else
                return false;
        }
        
        /* USE RECURRSION FOR THE REST OF THE BOARD */
        return rows(board,start+1);
    }
    
    private boolean cols(char[][]board,int start){
        
        if(start >= board[0].length)
            return true;
        
        Set<Character>set = new HashSet<>();
        
        for(int i = 0; i < board.length; i++){
            char tmp = board[i][start];
            
            if(tmp=='.' || set.add(tmp))
                continue;
            else
                return false;
        }
        
        return cols(board,start+1);
    }
    
    private boolean boxes(char[][]board,int i, int j){
       if(i >= board.length || j >= board[0].length)
           return true;
        
        Set<Character>set = new HashSet<>();
        System.out.println("START: " + i + ", " + j);
        for(int m = i; m < i+3; m++){
            for(int n = j; n < j+3; n++){
                
                char tmp = board[m][n];
                System.out.println(tmp);
                if(tmp=='.' || set.add(tmp))
                    continue;
                else
                    return false;
            }
        }
        return boxes(board,i+3,j) && boxes(board,i,j+3);
    }
}


    /*
    Set seen = new HashSet();
    for (int i=0; i<9; ++i) {
        for (int j=0; j<9; ++j) {
            char number = board[i][j];
            if (number != '.')
                if (!seen.add(number + " in row " + i) ||
                    !seen.add(number + " in column " + j) ||
                    !seen.add(number + " in block " + i/3 + "-" + j/3))
                    return false;
        }
    }
    return true;
        
    */
