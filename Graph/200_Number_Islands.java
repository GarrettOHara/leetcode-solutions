import java.util.*;

class Solution {
    public static void main(String[] args){
        char[][]arr = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','1'}
        };
        
        System.out.println("USING BFS ITERATIVE: \n"+numIslandsBFS(arr));
        System.out.println("USING DFS ITERATIVE: \n"+numIslandsDFS(arr, true));
        // NOT WORKING
        // System.out.println("USING DFS RECURSIVE: \n"+numIslandsDFS(arr, false));
    }
    public static int numIslandsBFS(char[][] grid) {
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
    public static int numIslandsDFS(char[][] grid, boolean method) {
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
                        if(method)
                            count += DFS(grid,visited,i,j);
                        else{
                            DFSrecur(grid, visited, i, j);
                            count++;
                        }
                    }
                }
            }
        }
        
        return count;
    }
    private static int DFS(char[][]grid,Boolean[][]visited,int i, int j){
        Stack<int[]>stack = new Stack<>();
        int[][] directions = {
            {0,1}, {0,-1}, {1,0}, {-1,0}
        };

        /* STORE CURRENT NODE */
        int[]curr = {i,j};
        stack.push(curr);

        while(!stack.isEmpty()){
            curr = stack.pop();
            for(int[] dir : directions){
                int x = curr[0]+dir[0];
                int y = curr[1]+dir[1];
                if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y]=='1' && !visited[x][y]){
                    stack.push(new int[]{x,y});
                    visited[x][y]=true;
                } else 
                    continue;
            }
        }
        return 1;
    }

    private static void DFSrecur(char[][] grid, Boolean[][] visited, int i, int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || visited[i][j])
            return;
        
        visited[i][j] = true;

        if(grid[i][j]=='0')
            return;

        int[][] directions = {
            {0,1}, {0,-1}, {1,0}, {-1,0}
        };

        for(int[]dir : directions){
            DFSrecur(grid, visited, i+dir[0], j+dir[1]);
        }

        return;
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