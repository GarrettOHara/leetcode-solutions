import java.util.*;
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        // Queue<int[]>pq = new PriorityQueue<>((a,b) -> (a[0],b[0]));
        int closest = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length-2; i++){
            int start = i+1, end = nums.length-1;
            while(start < end){
                int sum = nums[i]+nums[start]+nums[end];
                if(sum > target)
                    end--;
                else 
                    start++;
                if(Math.abs(sum-target) < Math.abs(closest-target))
                    closest = sum;
            }
        }
        return closest;
    }
}

/**
O(n^3): TIME LIMIT EXCEEDED

    Queue<int[]>pq = new PriorityQueue<>((a,b) -> (a[0]-b[0]));
    for(int i = 0; i < nums.length-2; i++){
        for(int j = i+1; j < nums.length -1; j++){
            for(int k = j+1; k < nums.length; k++){
                int sum = nums[i]+nums[j]+nums[k];
                pq.offer(new int[]{Math.abs(sum-target),sum});
            }
        }
    }
    return pq.poll()[1];

**/
