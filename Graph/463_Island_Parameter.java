class Solution {
    int count = 0;
    public int islandPerimeter(int[][] grid) {
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j]==1)
                    DFS(grid,i,j);
            }
        }
        return count;
    }
    
    private void DFS(int[][]grid,int i, int j){
        int[][] directions = {
            {1,0},{0,1},{-1,0},{0,-1}            
        };
        grid[i][j] = -1;
        for(int[] dir : directions){
            int a = i+dir[0];
            int b = j+dir[1];
            
            if(a<0||b<0||a>=grid.length||b>=grid[a].length||grid[a][b]==0)
                count++;
            else if(grid[i][j]==1)
                DFS(grid,a,b);
        }
        return;
    }
}


/*

FASTER SOLUTION FROM SUBMISSIONS

class Solution {
    public int islandPerimeter(int[][] grid) {
        int count=0;
        for (int r=0; r < grid.length; ++r) {
            for (int c=0; c < grid[0].length; ++c) {
                
                if (grid[r][c] == 1) {
                    int num = 0;
                    
                    // UP
                    if (r > 0) {
                        num += grid[r-1][c];
                    }
                    
                    // DOEN
                    if (r < grid.length-1) {
                        num += grid[r+1][c];
                    }
                    
                    // LEFT
                    if (c > 0) {
                        num += grid[r][c-1];
                    }
                    
                    // RIGHT
                    if (c < grid[0].length-1) {
                        num += grid[r][c+1];
                    }
                    count += 4-num;
                }
            }
        }
        return count;
     
    }
    
}

*/
