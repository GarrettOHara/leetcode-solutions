import java.util.*;

class Solution {
    public int maxProduct(int[] nums) {
        return arr(nums);
        // return heap(nums);
    }
    
    public int arr(int[] nums){
        Arrays.sort(nums);
        int index = nums.length-1;
        int res = (nums[index]-1)*(nums[index-1]-1);
        return res;
    }
    
    public int heap(int[] nums){
        if(nums.length == 2) return (nums[0]-1) * (nums[1]-1);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            nums.length,
            Collections.reverseOrder()
        );
        
        for(int i = 0; i < nums.length; i++)
            pq.offer(nums[i]-1);
        
        
        return pq.poll() * pq.poll();
    }
}
