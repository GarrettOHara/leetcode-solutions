class Solution {
    public int findCenter(int[][] edges) {
        /**
        find the node that has the highest degrees
        
        OPTIMAL SOLUTION: O(1)
        
        return e[0][0] == e[1][0] || e[0][0] == e[1][1] ? e[0][0] : e[0][1];
        **/
        
        // memoize degrees
        int[] arr = new int[100001];

        // helpers
        int pos = 0, max = 0;
        
        // iterate edge set
        for(int i = 0; i < edges.length; i++){
            int a = edges[i][0]-1;
            int b = edges[i][1]-1;
            
            // increment degree of both nodes
            arr[a]++;
            arr[b]++;
            
            // update highest degree
            if(arr[a] > max){
                pos = a;
                max = arr[a];
            } else if(arr[b] > max){
                pos = b;
                max = arr[b];
            }
        }

        return pos+1;
    }
}
