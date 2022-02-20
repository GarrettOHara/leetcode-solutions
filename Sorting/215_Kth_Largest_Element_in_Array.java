class Solution {
    public int findKthLargest(int[] nums, int k) {
        // sorting array
        return sorting(nums,k);
        
        // using a heap
        // return heapping(nums, k);
    }
    private int sorting(int[]nums,int k){
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
    private int heapping(int[]nums,int k){
        PriorityQueue<Integer>pq = new PriorityQueue<>(10,Collections.reverseOrder());
        for(int i : nums)
            pq.offer(i);
        
        for(int i = 1; i < k; i++)
            pq.poll();
        
        return pq.poll();
    }
}
