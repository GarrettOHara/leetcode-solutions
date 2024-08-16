class Solution {
    public int minimumEffortPath(int[][] heights) {
        // MIN HEAP TO STORE ALLL NEXT NEIGHBORS AND 
        // REACH END NODE 
        
        // STORE PATH IN VISITED ARRAY, OR USE FLOOD FILL 
        // TECHNIQUE
        
        // STORE PREVIOUS VALUE AS INT
        // EACH NEW NODE, CALCULATE ABSOLUTE DIFFERENCE
        // STORE VALUE IN TMP VARIABLE FOR NEXT
        
        // MUST GO FROM TOP LEFT TO BOTTOM RIGHT, DIKSTRA?
        
        int[] DIR = new int[]{0, 1, 0, -1, 0};
        int m = heights.length, n = heights[0].length;
        
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        int[][]visited = new int[m][n];
        int difference = 0;
        int previous   = 0;
       
        for(int[] arr : visited)
            Arrays.fill(arr,Integer.MAX_VALUE);
        
        pq.offer(new int[]{0,0,0});
        while(pq.size()>0){
            int[] top = pq.poll();
            int distance = top[0], row = top[1], col = top[2];
            if(distance > visited[row][col])
                continue;
            if(row == m-1 && col == n-1)
                return distance;
            
            for(int i = 0; i < DIR.length-1; i++){
                int new_row = row+DIR[i], new_col = col+DIR[i+1];
                if(new_row >= 0 && new_row < m && new_col >= 0 && new_col < n){
                    int new_distance = 
                        Math.max(distance, Math.abs(heights[new_row][new_col] -
                                                    heights[row][col])
                                );
                    if(visited[new_row][new_col] > new_distance){
                        visited[new_row][new_col] = new_distance;
                        pq.offer(new int[]{visited[new_row][new_col],new_row,new_col});
                    }
                    
                }
            }
        }
        return -1; // GRAPH NOT TRAVERSABLE
    }
}
