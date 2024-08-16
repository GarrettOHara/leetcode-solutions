/*
 After becoming famous, the CodeBots decided to move into a new building together. Each of the rooms has a different cost, and some of them are free, but there's a rumour that all the free rooms are haunted! Since the CodeBots are quite superstitious, they refuse to stay in any of the free rooms, or any of the rooms below any of the free rooms.

Given matrix, a rectangular matrix of integers, where each value represents the cost of the room, your task is to return the total sum of all rooms that are suitable for the CodeBots (ie: add up all the values that don't appear below a 0).

matrix = [[0, 1, 1, 2], 
          [0, 5, 0, 0], 
          [2, 0, 3, 3]]

solution(matrix) = 9
 */

 int solution(int[][] matrix) {
    /* TRAVERSE MATRIX FOR 0
       IF 0, DFS ONLY DOWN AND MARK ALL -1
       CONTINUE SEARCH
    */
    int sum = 0;
    for(int i = 0; i < matrix.length; i++){
        for(int j = 0; j < matrix[i].length; j++){
            if(matrix[i][j]==0)
                DFS(matrix,i,j);
            else if(matrix[i][j] > 0)
                sum = sum + matrix[i][j];
        }
    }

    return sum;
}

void DFS(int[][]matrix, int i, int j){
    if(i>=matrix.length)
        return;

    matrix[i][j] = -1;

    DFS(matrix, i+1, j);
}

