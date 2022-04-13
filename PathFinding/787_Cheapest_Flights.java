class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        // < Node, (Destination, Cost) >
        Map<Integer,List<int[]>> graph = new HashMap<>();
        
        // min heap, compare cost of edges
        PriorityQueue<int[]> heap = new PriorityQueue<>( (a,b) -> a[1]-b[1] );
        
        for(int i = 0; i < flights.length; i++){
            
            if(!graph.containsKey(i))
                graph.put(i,new ArrayList<>());

            // need to add bi-directional / non-directed graph edges
            graph.get(i).add(new int[]{flights[i][0],flights[i][2]});
            graph.get(i).add(new int[]{flights[i][1],flights[i][2]});
            
        }
        
        
        heap.offer(new int[]{0,0});
        
        
        return 0;
    }
}
