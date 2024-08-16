class Solution {
    Queue<int[]> q;
    
    public void solve(char[][] board) {
        q = new LinkedList<>();
        int x = board.length;
        int y = board[0].length;
        
        
        // Find all disqualifying nodes
        for(int i=0; i<x; i++){
            if(board[i][0]=='O'){
                q.offer(new int[]{i,0});
                board[i][0]='+';
            }
            if(board[i][y-1]=='O'){
                q.offer(new int[]{i,y-1});
                board[i][y-1]='+';
            }
        }
        
        for(int i=0; i<y; i++){
            if(board[0][i]=='O'){
                q.offer(new int[]{0,i});
                board[0][i]='+';
            }
            if(board[x-1][i]=='O'){
                q.offer(new int[]{x-1,i});
                board[x-1][i]='+';
            }
        }
            
        bfs(q, board,x,y);
        for(int i=0; i<x; i++){
            for(int j=0; j<y; j++){
                if(board[i][j]=='+')
                    board[i][j]='O';
                else if(board[i][j]=='O')
                    board[i][j]='X';
            }
        }
    }
    private void bfs(Queue<int[]> q, char[][] board, int x, int y){
        int[][]directions= new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        while(q.size()>0){
            int[] node = q.poll();
            for(int[] dir : directions){
                int newX = dir[0]+node[0];
                int newY = dir[1]+node[1];
                
                if(newX<0 || newY<0 || newX>x-1 || newY>y-1 || board[newX][newY]=='+')
                    continue;
                else if(board[newX][newY]=='O'){
                    board[newX][newY]='+';
                    q.offer(new int[]{newX,newY});
                }
            }
        }
    }
}


/**

    boolean flip;
    boolean[][]visited;
    int x,y;
    
    public void solve(char[][] board) {
        x = board.length;
        y = board[0].length;
        visited = new boolean[x][y]; //default false
        
        for(int i=1; i<x-1; i++){
            Queue<int[]>q = new LinkedList<>();
            for(int j=1; j<y-1; j++){
                
                visited[i][j]=true;
                
                if(board[i][j]=='O'){
                    
                    q.offer(new int[]{0,1});
                    flip = true;
                    bfs(q,board);
                }
                
                if(flip){                    
                    for(int[] node : q){
                        board[node[0]][node[1]]='X';
                    }
                }
            }
        }
    }
    private void bfs(Queue<int[]>q,char[][] board){
        while(q.size()!=0){
            int[] pos = q.poll();
            int[][] directions = new int[][]{{1,0},{0,1},{0,-1},{-1,0}};
            for(int[] dir : directions){
                int m = pos[0]+dir[0];
                int n = pos[1]+dir[1];
                System.out.println(m+", "+n);
                if(!(m<x && n<y && m>=0 && n>=0))
                    break;
                if(visited[m][n])
                    continue;
                if(board[m][n]=='O')
                    q.offer(new int[]{m,n});
                
                visited[m][n]=true;
            }
        }
    }
    
**/
