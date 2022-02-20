class Solution {

    public int[][] kClosest(int[][] points, int k) {
        
        /* OVERRIDE PRIORITY QUEUE COMPARATOR */
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return Integer.compare(euclid_alg(a),euclid_alg(b));
            }
        });
        
        /* BUILD HEAP */
        for(int[] coord : points)
            pq.offer(coord);
        
        /* POLL K VALUES OFF HEAP */
        int[][]res = new int[k][2];
        while(k>0)
            res[--k] = pq.poll();
        
        return res;
    }

    /* HELPER DISTANCE FUNCTIONS */
    private int euclid_alg(int[]coord){
        return square(coord[0]) + square(coord[1]);
    }
    private int square(int n){
        return (int) Math.pow(n,2);
    }
}
