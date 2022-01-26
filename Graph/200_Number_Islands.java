import java.util.*;

class Solution {
    public static void main(String[] args){
        char[][]arr = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };

        System.out.println(numIslands(arr));

    }
    public static int numIslands(char[][] grid) {
        Boolean[][] visited = new Boolean[grid.length][grid[0].length];
        for (Boolean[] row: visited) 
            Arrays.fill(row, false);
        
        int count = 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(!visited[i][j]){
                    if(grid[i][j]=='0')
                        visited[i][j] = true;
                    else{
                        visited[i][j]=true;
                        count += BFS(grid,visited,i,j);
                    }
                }
            }
        }
        
        return count;
    }
    
    private static int BFS(char[][]grid,Boolean[][]visited,int i, int j){
        /* CREATE QUEUE TO STORE NODES FOR EXPLORATION */
        Queue<int[]>q = new LinkedList<>();
        
        /* SET ARRAY OF ALL DIRECTIONS TO SEARCH */
        int[][] directions = {
            {0,1}, {0,-1}, {1,0}, {-1,0}
        };

        /* STORE CURRENT NODE */
        int[]curr = {i,j};
        q.offer(curr);
        
        /* START BFS */
        while(q.size()!=0){

            /* TAKE NEXT NODE */
            curr = q.poll();
            
            /* EXPLORE NODE */
            for(int[] dir : directions){

                int x = curr[0]+dir[0];
                int y = curr[1]+dir[1];
                
                /* CHECK IF NODE SOULD BE EXPLORED */
                if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y]=='1' && !visited[x][y]){
                    
                    /* ADD TO QUEUE */
                    q.offer(new int[]{x,y});

                    /* MARK VISIITATION */
                    visited[x][y] = true;
                }else
                    continue;
            }
        }
        
        /*EXPLORED ISLAND */
        return 1;
    }
}