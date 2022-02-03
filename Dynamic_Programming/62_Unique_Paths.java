class Solution {
    public int uniquePaths(int m, int n) {
        int[]arr = new int[n];
        
        for(int i = 0; i < n; i++)
            arr[i] = 1;
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                arr[j]+=arr[j-1];
            }
        }
        return arr[n-1];
    }
}


/**

class Solution {
    public int uniquePaths(int m, int n) {
        int[][]graph = new int[m][n];
        
        graph[m-1][n-1]=1;
        
        return DFS(graph,0,0);
    }
    
    private int DFS(int[][] graph, int i, int j){
        
        if(i<0||j<0||i>=graph.length||j>=graph[0].length||graph[i][j]==1)
            return 0;
        
        int sum = 0;
        if(graph[i][j]==0)
            sum++;
        
        graph[i][j]=1;
        
        sum+=DFS(graph,i+1,j);
        sum+=DFS(graph,i-1,j);
        sum+=DFS(graph,i,j+1);
        sum+=DFS(graph,i,j-1);
        
        return sum;        
    }
}

**/
