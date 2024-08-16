import java.util.*;

class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++)
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        
        // Greatest to least on second element
        Queue<int[]> pq = new PriorityQueue<>( (a,b) -> b[1] - a[1] );
        
        for(Map.Entry<Integer,Integer> entry : map.entrySet())
            pq.offer(new int[]{entry.getKey(),entry.getValue()});
        
        int sum = 0, count = 0;
        while(pq.size() > 0){
            int[] tmp = pq.poll();
            sum+=tmp[1];
            count++;
            if(sum >= arr.length/2)
                break;
        }
        
        return count;
    }
}
