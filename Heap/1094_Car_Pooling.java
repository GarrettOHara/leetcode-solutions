import java.util.*;

class Solution {
  /* Sort Array based on pickup loctions then use PQ to sort 
   * dropoff destinations */
  public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<int[]>pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(a[2],b[2])
        );
        
        Arrays.sort(trips, new Comparator<int[]>(){
            public int compare(int[] i1, int[] i2) {
                return i1[1] - i2[1];
            }
        });
        for(int i = 0; i < trips.length; i++){
            
            // Check if we can remove passengers
            while(pq.size()>0 && pq.peek()[2] <= trips[i][1]){
                capacity += pq.peek()[0];
                pq.poll();
            }
            
            // Add passengers
            capacity -= trips[i][0];
            pq.offer(trips[i]);
            if(capacity < 0)
                return false;
        }
        return true;
    }
}
/**


        PriorityQueue<int[]>pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(a[1],b[1])
        );
        Map<Integer,int[]> car = new HashMap<>();
        int curr_capacity = 0;
        int max = Integer.MIN_VALUE;
        
        for(int[] arr : trips){
            pq.offer(arr);
            if(arr[2]>max)
                max = arr[2];
        }
        
        for(int i = 0; i < max; i++){
            if(curr_capacity > capacity) return false;
            else if(pq.isEmpty()) return true;
            int[] curr = pq.peek();
            
            if(car.containsKey(i)){
                curr_capacity -= curr[0];
                car.remove(i);
            }
            System.out.println(i);
            if(i==curr[1]){
                car.put(curr[2],curr);
                curr_capacity += curr[0];
                pq.poll();
            }
        }
        System.out.println();
        return true;

**/

