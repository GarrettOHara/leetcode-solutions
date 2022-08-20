import java.util.*;

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> a[0]!=b[0] ? a[0]-b[0] : a[1]-b[1] );
        
        for(int i = 0; i< mat.length; i++){
            int sum = IntStream.of(mat[i]).sum();
            pq.offer(new int[]{sum,i});
        }
        
        int[] res = new int[k];
        int i = 0;
        while(k-- > 0){
            res[i] = pq.poll()[1];
            i++;
        }
        return res;
    }
}
