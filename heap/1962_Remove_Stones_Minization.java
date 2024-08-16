class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer>pq = 
            new PriorityQueue<>(Collections.reverseOrder());
        
        int sum = 0;
        for(int i : piles){
            sum = sum + i;
            pq.offer(i);
        }
        
        while(pq.size()>0 && k-->0){
            int curr = pq.poll();
            
            sum     -= Math.floor(curr/2);
            curr    -= Math.floor(curr/2);
            
            pq.offer(curr);
        }
        return sum;
    }
}


/**

        PriorityQueue<Integer>pq = 
            new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i : piles)
            pq.offer(i);
        
        for(; k>0; k--){
            int val = (int) Math.ceil((double)pq.poll()/2d);
            pq.offer(val);
        }
        
        while(pq.size()>0)
            k+= pq.poll();    
        
        return k; 
***/
